package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms(); //Get symptoms from file "symptoms.txt"

        Map<String, Integer> map = analyticsCounter.countSymptoms(symptoms);//Map = { symptomName=symptomOccurrence }

        Map<String, Integer> symptomsSorted = analyticsCounter.sortSymptoms(map);//Sort symptoms alphabetically

        analyticsCounter.writeSymptoms(symptomsSorted);//Write symptoms in file "result.out"
    }

}
