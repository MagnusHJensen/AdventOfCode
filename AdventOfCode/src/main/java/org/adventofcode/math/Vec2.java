package org.adventofcode.math;

import java.nio.FloatBuffer;

public class Vec2 {

    /**
     * Parse from format "x,y"
     * @param string
     * @return
     */
    public static Vec2 parseVec2(String string) {
        String[] tokens = string.split(",");
        return new Vec2(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1]));
    }

    private float x;
    private float y;

    public Vec2 () {
        this(0,0);
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vec2 copy () {
        return new Vec2(x, y);
    }

    public Vec2 add (Vec2 other) {
        x += other.x;
        y += other.y;
        return this;
    }

    public Vec2 sub (Vec2 other) {
        x -= other.x;
        y -= other.y;
        return this;
    }

    public Vec2 mul (float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    public Vec2 div (float scalar) {
        x /= scalar;
        y /= scalar;
        return this;
    }

    public float dot (Vec2 other) {
        return x * other.x + y * other.y;
    }

    public float cross (Vec2 other) {
        return this.x * other.getY() - this.y * other.getX();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vec2) {
            Vec2 other = (Vec2)obj;
            return x == other.x && y == other.y;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vec2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
