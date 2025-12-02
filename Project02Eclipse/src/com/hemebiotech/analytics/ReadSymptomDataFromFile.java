package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filePath;

    /**
     * Creates an {@code ReadSymptomDataFromFile} instance that reads symptoms from the provided file path.
     *
     * @param filepath the path to the file containing the symptom data
     */
    public ReadSymptomDataFromFile(String filepath) {

        this.filePath = filepath;
    }

    /**
     * Reads all symptoms from the file specified during construction.
     * Each line of the file is symptom name.
     *
     * @return a list of symptom read from the input file
     */
    @Override
    public List<String> getSymptoms() {

        ArrayList<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
