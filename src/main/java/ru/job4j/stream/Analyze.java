package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс описывает методы работы с потоками
 * @author Dmitry Lebedev
 * <a href="https://job4j.ru/profile/exercise/36/task-view/267">Ссылка на задачу</a>
 */

public class Analyze {

    /**
     * Метод вычисляет общий средний общий средний бал по всем предметам.
     * @param stream принимает стрим из объектов Pupil
     * @return возвращает примитив double
     * @see Pupil
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(Double.NaN);
    }

    /**
     * Метод вычисляет средний бал по всем предметам индивидуально для каждого ученика.
     * @param stream принимает стрим из объектов Pupil
     * @return список объектов Tuple. name = Фамилия ученика, score = средний бал по всем предметам у ученика.
     * @see Pupil
     * @see Tuple
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.name(), p.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(Double.NaN)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний бал по каждому предмету среди учеников.
     * @param stream принимает стрим из объектов Pupil
     * @return Список объектов Tuple. name = название предмета, score = средний бал по предмету среди учеников.
     * @see Pupil
     * @see Tuple
     */

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет лучшего ученика через суммирование баллов по всем предметам.
     * @param stream принимает стрим из объектов Pupil
     * @return Объект Tuple. name = фамилия ученика, score = суммарный бал по всем предметам.
     * @see Pupil
     * @see Tuple
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.name(), p.subjects().stream()
                        .mapToDouble(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    /**
     * Метод вычисляет самые успешный предмет на основе суммы баллов по предмету среди учеников.
     * @return Объект Tuple. name = называние предмета, score = суммарный бал по предмету среди учеников.
     * @see Pupil
     * @see Tuple
     */

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}
