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
public class Permission {
    @EqualsAndHashCode.Include
    private int id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @NonNull
    @Getter
    @Setter
    @Singular("rule")
    private List<String> rules;
}
