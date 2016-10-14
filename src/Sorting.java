import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorting {
	private static int max = 10;
	private static List<Integer> input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorting s = new Sorting();

		List<Integer> output = s.insertSort();
		showArray(output);
	}

	private static void showArray(final List<Integer> arr) {
		for (int i = 0; i < arr.size() ; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println("\n");
	}

	private ArrayList<Integer> insertSort() {
		// TODO Auto-generated method stub
		ArrayList<Integer> output = new ArrayList<>(input);
		for (int i = 1 ; i <= input.size() ; i++) {
			showArray(input);
			int j = i;
			while (j > 0) {
				if (input.get(j) < input.get(j-1)) {
					int tmp = input.get(j);
					input.set(j,  input.get(j-1));
					input.set(j-1, tmp);
				}
				j--;
			}
		}
		return output;
	}

	public Sorting() {
		input = new ArrayList<>(max);
		Random rand = new Random();
		for (int i = 0 ; i < max ; i++) {
			int r = rand.nextInt(100);
			System.out.println(r + ",");
			input.add(i,  r);
		}
		System.out.println("\n");
	}
}
