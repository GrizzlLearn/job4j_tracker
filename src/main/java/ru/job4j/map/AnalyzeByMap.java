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

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        Map<String, Integer> tmp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (tmp.containsKey(subject.name())) {
                    tmp.put(subject.name(), tmp.get(subject.name()) + subject.score());
                } else {
                    tmp.put(subject.name(), subject.score());
                }
            }
        }
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
        return null;
    }
}
