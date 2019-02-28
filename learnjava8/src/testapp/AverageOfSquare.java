package testapp;

import java.util.Arrays;

public class AverageOfSquare {

	public static void main(String[] args) {
		// average of square s of int array
		
		Arrays.stream(new int[]{2, 4, 6, 8, 10})
		.map(x->x * x)
		.average()
		.ifPresent(System.out::println);
	}
}
