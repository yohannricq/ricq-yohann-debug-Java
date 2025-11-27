package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        Map<String, Integer> symptomsSorted = new TreeMap<>(symptoms); //symptoms sorted alphabetically

        if(filePath != null) {

            try(FileWriter fileWriter = new FileWriter(this.filePath)) {
                for (Map.Entry<String, Integer> entry : symptomsSorted.entrySet()) {
                    String symptomName = entry.getKey();
                    Integer symptomOccur = entry.getValue();
                    fileWriter.write(symptomName + ": " + symptomOccur + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
