package dk.magnusjensen.adventofcode.cal2021.day_five;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private ArrayList<Point> points;
	private boolean includeDiag;

	public Line(Point start, Point end, boolean includeDiag) {
		points = new ArrayList<>();
		this.includeDiag = includeDiag;
		populatePointList(start, end);
	}

	private void populatePointList(Point start, Point end) {

		if (start.getX() != end.getX() && start.getY() != end.getY() && !this.includeDiag) return;

		int dirX = start.getX() == end.getX() ? 0 : end.getX() - start.getX() > 0 ? 1 : -1;
		int dirY = start.getY() == end.getY() ? 0 : end.getY() - start.getY() > 0 ? 1 : -1;

		points.add(start);
		Point point = new Point(start.getX() + dirX, start.getY() + dirY);
		while (!point.equals(end)) {
			points.add(point);
			point = new Point(point.getX() + dirX, point.getY() + dirY);
		}
		points.add(end);
	}

	public void printPoints() {
		System.out.print("Line[");
		for (Point point : points) {
			System.out.print(point + ",");
		}
		System.out.println("]");
	}

	public List<Point> getPoints() {
		return List.copyOf(this.points);
	}
}
