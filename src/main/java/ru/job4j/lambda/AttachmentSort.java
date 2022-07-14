package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 345", 13),
                new Attachment("image 23", 34)
        );
        Comparator comparatorSize =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparatorSize);
        System.out.println(attachments);

        Comparator<Attachment> comparatorName = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);

        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());
        attachments.sort(cmpText);
        System.out.println(attachments);
        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(right.getName().length(), left.getName().length());
        attachments.sort(cmpDescSize);
        System.out.println(attachments);
    }
}
