package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double result = 0.0d;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score() / (double) pupil.subjects().size();
            }
        }
        return result / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        for (Pupil pupil : pupils) {
            double average = 0.0d;
            for (Subject subject : pupil.subjects()) {
                average += subject.score() / (double) pupil.subjects().size();
            }
            result.add(new Label(pupil.name(), average));
        }
        return result;
    }

    private static Map<String, Integer> listToMap(List<Pupil> pupils) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (result.containsKey(subject.name())) {
                    result.put(subject.name(), result.get(subject.name()) + subject.score());
                } else {
                    result.put(subject.name(), subject.score());
                }
            }
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        Map<String, Integer> tmp = listToMap(pupils);
        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            result.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        for (Pupil pupil : pupils) {
            double sum = 0.0d;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        Collections.sort(result, new PupilDescByScore());
        return result.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        Map<String, Integer> tmp = listToMap(pupils);
        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(result, new LabelAscByScore());
        return result.get(result.size() - 1);
    }
}
