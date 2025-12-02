package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> map = analyticsCounter.countSymptoms(symptoms);

        Map<String, Integer> symptomsSorted = analyticsCounter.sortSymptoms(map);

        analyticsCounter.writeSymptoms(symptomsSorted);
    }

}
