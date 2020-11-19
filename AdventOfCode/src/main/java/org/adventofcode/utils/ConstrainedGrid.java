package org.adventofcode.utils;

import org.adventofcode.math.Vec2;

/**
 * Define a grid any shape and allow movement on all spaces with content
 */
public class ConstrainedGrid<T> {
    private T[][] grid;
    private T emptySpot;
    private Vec2 start;
    private int x;
    private int y;

    public ConstrainedGrid (T[][] grid, int startX, int startY, T emptySpot) {
        this.grid = grid;
        this.emptySpot = emptySpot;
        this.start = new Vec2(startX, startY);
        this.x = startX;
        this.y = startY;
    }

    public void moveX (int x) {
        if (x > 0) {
            for (int i = 1; i < x+1; i++) {
                if (this.x+i >= grid[y].length || grid[y][this.x+i].equals(emptySpot)) {
                    this.x += i-1;
                    return;
                }
            }
        }
        else {
            for (int i = -1; i > x-1; i--) {
                if (this.x+i < 0 || grid[y][this.x+i].equals(emptySpot)) {
                    this.x += i+1;
                    return;
                }
            }
        }

        this.x += x;
    }

    public void moveY (int y) {
        if (y > 0) {
            for (int i = 1; i < y+1; i++) {
                if (this.y+i >= grid.length || grid[this.y+i][x].equals(emptySpot)) {
                    this.y += i-1;
                    return;
                }
            }
        }
        else {
            for (int i = -1; i > y-1; i--) {
                if (this.y+i < 0 || grid[this.y+i][x].equals(emptySpot)) {
                    this.y += i+1;
                    return;
                }
            }
        }

        this.y += y;
    }

    public T getContentAtPosition() {
        return grid[y][x];
    }

    public void reset () {
        x = (int)start.getX();
        y = (int)start.getY();
    }
}
