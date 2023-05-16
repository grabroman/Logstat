/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 29, 2021 3:32:54 PM
 */
package com.logstat.model.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Sets map to display
 *
 *  input map
 *  IllegalArgumentException when input map is null
 */
public class ReportFind implements Report {

    private Map<String, List<String>> findResult;

    public ReportFind(Map<String, List<String>> info) {
	findResult = info;
    }


    public void setRes(Map<String, List<String>> findResult) {
        if (findResult == null) {
            throw new IllegalArgumentException("Input map is null");
        }
        this.findResult = findResult;
    }

    @Override
    public List<String> getAsList() {
        List<String> listFindResult = new ArrayList<>(findResult.size() + 1);
         for (String key: findResult.keySet()) {
             addToListResult(key, listFindResult);
        }

	return listFindResult;
    }

    private void addToListResult(String keyMap, List<String> listFindResult) {
        List<String> listFromMap = findResult.get(keyMap);
        listFindResult.add(keyMap);
        for (String value: listFromMap) {
            listFindResult.add("\t" + value);
        }
    }
    
}
