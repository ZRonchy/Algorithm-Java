package interview;

public class DecomposeNumber {

	private static void print(int[] values, int n) {
		for (int i = 0; i 0) {
			values[index] = x;
			decompose(0, values, index + 1);
		}
	}

	public static void decompose(int x) {
		int[] values = new int[x];
		decompose(x, values, 0);
	}

	public static void main(String[] args) {
		int x = 5;
		decompose(x);
	}
}
