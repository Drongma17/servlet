package testapp;

import java.util.stream.IntStream;

public class SumInStream {

	public static void main(String[] args) {
		// Integer stream with sum
		System.out.println(
		IntStream
		.range(1, 5)
		.sum());
		System.out.println();
	}
}
