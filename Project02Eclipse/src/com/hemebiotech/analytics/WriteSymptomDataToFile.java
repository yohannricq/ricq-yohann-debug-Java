package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if(filePath != null) {

            try(FileWriter fileWriter = new FileWriter(this.filePath)) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
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
