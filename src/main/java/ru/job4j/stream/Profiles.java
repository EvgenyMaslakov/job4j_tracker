package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profil -> profil.getAddress())
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return collect(profiles)
                .stream()
                .sorted((left, right) -> left.getCity().compareTo(right.getCity()))
                .distinct()
                .collect(Collectors.toList());

    }
}