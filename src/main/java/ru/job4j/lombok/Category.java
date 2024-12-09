package ru.job4j.lombok;

import lombok.*;

/**
 * @author dl
 * @date 09.12.2024 22:18
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@RequiredArgsConstructor
public class Category {
    @NonNull
    @Getter
    @EqualsAndHashCode.Include
    private final Integer id;

    @Getter
    @Setter
    private String name;
}
