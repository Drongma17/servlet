package testapp;

import java.util.stream.IntStream;

public class SkipInStream {

	public static void main(String[] args) {
		// Integer stream with skip 
		IntStream
		.range(1, 10)
		.skip(5)
		.forEach(x->System.out.println(x));
		System.out.println();
	}
}
