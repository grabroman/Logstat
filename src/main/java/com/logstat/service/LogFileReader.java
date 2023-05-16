
package com.logstat.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import com.logstat.model.Log;


public class LogFileReader {
    private String filePath;

    public LogFileReader(String filePath) {
        this.filePath = filePath;
    }


    public Stream<Log> readAll() {
        Stream<Log> logs;
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
            logs = toStream(br).map(log -> {
                Log res = null;
                try {
                    res = Logs.parse(log);
                } catch (RuntimeException e) {
                    e.fillInStackTrace();
                }
                return res;
            }).filter(Objects::nonNull);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read the file: " + filePath);
        }
        return logs;
    }

    private static Stream<String> toStream(BufferedReader br) {
        return br.lines().onClose(asUncheckedAutoCloseable(br));
    }

    private static Runnable asUncheckedAutoCloseable(AutoCloseable ac) {
        return () -> {
            try {
                ac.close();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        };
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
