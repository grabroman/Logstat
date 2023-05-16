/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 29, 2021 2:05:17 PM
 */
package com.logstat.service.collector;

import java.util.stream.Stream;

import com.logstat.model.Command;
import com.logstat.model.Log;
import com.logstat.model.report.Report;


public interface Collector {
    Report collect(Stream<Log> logs, Command comand);




}
