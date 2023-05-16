package com.logstat.model.report;


import java.util.List;

/**
 * return list of rows should be printed based on input map
 */
public interface Report {

    List<String> getAsList();
}
