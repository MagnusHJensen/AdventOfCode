package org.adventofcode.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    private ListUtils () {}

    /**
     * Generate all possible permutations of the given list of items
     * @param original
     * @return
     */
    public static <T> List<List<T>> generateAllPermutations (List<T> original) {
        if (original.isEmpty()) {
            List<List<T>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        T firstElement = original.remove(0);
        List<List<T>> returnValue = new ArrayList<>();
        List<List<T>> permutations = generateAllPermutations(original);
        for (List<T> smallerPermutated : permutations) {
            for (int i = 0; i <= smallerPermutated.size(); i++) {
                List<T> temp = new ArrayList<>(smallerPermutated);
                temp.add(i, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }
}
