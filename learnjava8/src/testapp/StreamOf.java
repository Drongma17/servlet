package testapp;

import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {
		// Stream.of, sorted and findFirst
		
		Stream.of("Ngawang", "Yeshi", "Dolma")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
	}
}
