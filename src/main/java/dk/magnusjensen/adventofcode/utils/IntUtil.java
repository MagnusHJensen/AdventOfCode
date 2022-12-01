package dk.magnusjensen.adventofcode.utils;

public class IntUtil {

	public static int ANDGate(int a, int b) {
		return a & b;
	}

	public static int ORGate(int a, int b) {
		return a | b;
	}

	public static int NOTGate(int a) {
		return a ^ 65535;
	}

	public static int LEFTShift(int a, int amount) {
		return a << amount;
	}

	public static int RIGHTShift(int a, int amount) {
		return a >> amount;
	}
}
