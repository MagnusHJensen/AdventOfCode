package org.adventofcode.utils;

import org.adventofcode.math.Vec2;

public class ArrayUtils {
    private ArrayUtils() {}

    public static void fillRect2dArray (Object[][] array, Object value, Vec2 minCorner, Vec2 maxCorner) {
        for (int x = (int)minCorner.getX(); x < maxCorner.getX(); x++) {
            for (int y = (int)minCorner.getY(); y < maxCorner.getY(); y++) {
                array[x][y] = value;
            }
        }
    }
}
