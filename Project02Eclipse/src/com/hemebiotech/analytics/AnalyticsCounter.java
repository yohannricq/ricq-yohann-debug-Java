package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Creates a new {@code AnalyticsCounter} instance using the provided reader and writer.
     *
     * @param reader the {@link ISymptomReader} used to read symptoms from the input file
     * @param writer the {@link ISymptomWriter} used to write symptom data to the output file
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Reads all symptoms using the {@link ISymptomReader}.
     *
     * @return a list containing all symptoms read from the input source
     */
    public List<String> getSymptoms() {

        return reader.getSymptoms();
    }

    /**
     * Counts how many times each symptom occurs in the provided list.
     *
     * @param symptoms a list of symptom names
     * @return a map where each key is a symptom and each value is the occurrence counts of this symptom
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> map = new HashMap<>();

        for (String symptom : symptoms) {
            map.put(symptom, map.getOrDefault(symptom, 0) + 1);
        }

        return map;
    }

    /**
     * Sorts the provided symptom map alphabetically by key.
     *
     * @param symptoms a map of symptoms and occurrence counts
     * @return a {@link TreeMap} containing the same entries sorted by symptom name
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the provided symptom data using the {@link ISymptomWriter}.
     *
     * @param symptoms a map of symptoms and their occurrence counts
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {

        writer.writeSymptoms(symptoms);
    }

}
