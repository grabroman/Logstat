package com.logstat.model.report;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Creates instance of ReportTop, sets default length of column to 0
 *
 *
 *  Sets map to display, changes length if info isn't empty
 *
 *  input map
 *  IllegalArgumentException when input map is null
 *
 *  Computes length of column based on the max length of keySet's elements
 *
 */
public class ReportTop implements Report {
    private Map<String, Integer> info;
    private int length;


    public ReportTop() {
        length = 0;
    }


    public void setRes(Map<String, Integer> info) {
        if (info == null) {
            throw new IllegalArgumentException("Input map is null");
        }

        this.info = info;

        if (!info.isEmpty()) {
            computeLength();
        }
    }


    private void computeLength() {
        Iterator<String> iterator = info.keySet().iterator();

        length = iterator.next().length();

        while (iterator.hasNext()) {
            length = Math.max(iterator.next().length(), length);
        }
    }

    @Override
    public List<String> getAsList() {
        List<String> result = new ArrayList<>(info.size() + 1);

        // Checks non-zero max length
        if (length > 0) {
            Iterator<String> iterator = info.keySet().iterator();

            result.add(String.format("| %-" + length + "s | %-9s |", "Key", "Value"));

            while (iterator.hasNext()) {
                String current = iterator.next();

                result.add(String.format("| %-" + length + "s | %-9d |", current, info.get(current)));
            }
        } else {
            result.add("There is no information.");
        }

        return result;
    }
}