package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    /**
     * Creates a new {@code WriteSymptomDataToFile} instance that writes output to the specified file.
     *
     * @param filePath the path to the file to write the symptom data
     */
    public WriteSymptomDataToFile(String filePath) {

        this.filePath = filePath;
    }

    /**
     * Writes the provided map of symptoms and their occurrence counts to the file.
     * Each map entry is written in the format:
     * {@code symptomName: occurrenceCounts}.
     *
     * @param symptoms symptoms a map where keys are symptom names and values are their occurrence counts
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filePath != null) {
            try (FileWriter fileWriter = new FileWriter(this.filePath)) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    String symptomName = entry.getKey();
                    Integer occurCounts = entry.getValue();
                    fileWriter.write(symptomName + ": " + occurCounts + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
