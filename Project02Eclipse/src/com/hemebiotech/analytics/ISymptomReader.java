package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {

    /**
     * Reads all symptoms from the data source.
     *
     * @return a list of symptom
     */
    List<String> getSymptoms();

}
