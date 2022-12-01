package dk.magnusjensen.adventofcode.maths;

public class Vec2 {

	private int x;
	private int y;

	public Vec2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vec2) {
			Vec2 instance = (Vec2) obj;
			return instance.getX() == this.x && instance.getY() == this.y;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.x + "," + this.y;
	}
}
