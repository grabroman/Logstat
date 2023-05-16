/**
 * Copyright 2021
 * <p>
 * All rights reserved.
 * <p>
 * Created on Oct 29, 2021 2:42:51 PM
 */
package com.logstat.service;

import java.io.IOException;

import com.logstat.model.report.Report;
import com.logstat.service.collector.Collector;
import com.logstat.service.collector.CollectorFactory;
import com.logstat.model.Command;


public class Controller {
    private ReportWriter writer = new ReportWriter();
    private LogFileReader reader = new LogFileReader(null);

    public void execute(Command command) {
        reader.setFilePath((command.getInputFile()));
        Collector collector = CollectorFactory.choose(command.getCollectorType());
        Report report = collector.collect(reader.readAll(), command);
        if (command.getOutputFile() != null) {
            writer.setFileOutput(command.getOutputFile());
        } else {
            writer.setFileOutput(null);
        }
        try {
            writer.write(report);
        } catch (IOException e) {
            throw new IllegalArgumentException("Something went wrong");
        }
    }
}
