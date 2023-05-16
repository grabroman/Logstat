
package com.logstat.service;

import com.logstat.model.report.Report;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;




public class ReportWriter {
    private boolean firstLine = true;
    private String fileOutput;

    public String getFileOutput() {
        return fileOutput;
    }

    public void setFileOutput(String fileOutput) {
        this.fileOutput = fileOutput;
    }

    public ReportWriter() {
    }

    public ReportWriter(String fileOutput) {
        this.fileOutput = fileOutput;
    }

    public void write(Report report) throws IOException {
        if (getFileOutput() != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(getFileOutput()))) {
                for (String line : report.getAsList()) {
                    if (firstLine) {
                        bw.write(line);
                        firstLine = false;
                    } else {
                        bw.write("\n" + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            for (String line : report.getAsList()) {
                System.out.println(line);
            }
        }
    }

}
