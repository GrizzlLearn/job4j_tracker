package ru.job4j.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double result = 0.0d;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score() / (double) pupils.size();
            }
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>(List.of());
        for (int i = 0; i < pupils.size(); i++) {
            for (int j = 1; j < pupils.size(); j++) {
                int y = 0;
                for (; y < pupils.get(i).subjects().size(); y++) {
                    double average = pupils.get(i).subjects().get(y).score();
                    average += pupils.get(j).subjects().get(y).score();
                    result.add(new Label(pupils.get(i).subjects().get(y).name(), average / pupils.size()));
                }
            }
            break;
        }
        return result;
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
