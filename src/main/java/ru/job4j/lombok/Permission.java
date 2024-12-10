package ru.job4j.lombok;

import lombok.*;

import java.util.List;

/**
 * @author dl
 * @date 10.12.2024 20:22
 */

@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(builderMethodName = "of")
@AllArgsConstructor
@Getter
@Setter
public class Permission {
    @EqualsAndHashCode.Include
    private final int id;

    private String name;

    @Singular("rules")
    private List<String> rules;
}
