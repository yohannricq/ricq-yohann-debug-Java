package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Writes the symptom data to the target destination.
     *
     * @param symptoms a map where each key is a symptom name and each value is the occurrence counts of this symptom
     */
    void writeSymptoms(Map<String, Integer> symptoms);

}
