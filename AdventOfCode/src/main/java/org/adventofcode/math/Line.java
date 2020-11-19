package org.adventofcode.math;

public class Line {

    public static Line fromPolar (Vec2 start, float angle, float length) {
        Vec2 offset = new Vec2((float)Math.cos(angle) * length, (float)Math.sin(angle) * length);
        Vec2 end = start.copy();
        end.add(offset);
        return new Line(start, end);
    }

    private Vec2 start;
    private Vec2 end;

    public Line (Vec2 start, Vec2 end) {
        this.start = start;
        this.end = end;
    }

    public Vec2 getStart() {
        return start;
    }

    public Vec2 getEnd() {
        return end;
    }

    public Vec2 getScalarVector () {
        return new Vec2(end.getX() - start.getX(), end.getY() - start.getY());
    }

    public Vec2 intersects (Line other) {
        float divisor = (start.getX() - end.getX()) * (other.start.getY() - other.end.getY()) - (start.getY() - end.getY()) * (other.start.getX() - other.end.getX());

        float t = ((start.getX() - other.start.getX()) * (other.start.getY() - other.end.getY()) - (start.getY() - other.start.getY()) * (other.start.getX() - other.end.getX())) / divisor;
        float u = ((start.getX() - end.getX()) * (start.getY() - other.start.getY()) - (start.getY() - end.getY()) * (start.getX() - other.start.getX())) / divisor;

        System.out.println(t + " | " + u);

        if (0 <= t && t <= 1) {
            return new Vec2(start.getX() + t * getScalarVector().getX(), start.getY() + t * getScalarVector().getY());
        }
        else if (0 <= u && u <= 1) {
            return new Vec2(other.start.getX() + u * other.getScalarVector().getX(), other.start.getY() + u * other.getScalarVector().getY());
        }

        return null;

//        Vec2 startDiff = other.start.copy().sub(start);
//
//        float t = startDiff.copy().cross(other.getScalarVector()) / getScalarVector().cross(other.getScalarVector());
//        float u = startDiff.copy().cross(getScalarVector()) / getScalarVector().cross(other.getScalarVector());
//
//        float scalarCross = getScalarVector().cross(other.getScalarVector());
//        float val = startDiff.copy().cross(getScalarVector());
//
//        if (scalarCross == 0 && val == 0) {
//            float t0 = startDiff.copy().dot(getScalarVector()) / getScalarVector().dot(getScalarVector());
//            float t1 = t0 + other.getScalarVector().dot(getScalarVector()) / getScalarVector().dot(getScalarVector());
//
//            if (other.getScalarVector().dot(getScalarVector()) < 0) {
//                if (t1 <= 0 && 0 <= t0 || t1 <= 1 && 1 <= t0) {
//                    return start.copy().add(getScalarVector().mul(t));
//                }
//            }
//            else {
//                if (t0 <= 0 && 0 <= t1 || t0 <= 1 && 1 <= t1) {
//                    return start.copy().add(getScalarVector().mul(t));
//                }
//            }
//        }
//        else if (scalarCross != 0 && 0 <= t && t <= 1 && 0 <= u && u <= 1) {
//            return start.copy().add(getScalarVector().mul(t));
//        }
//
//        return null;
    }
}
