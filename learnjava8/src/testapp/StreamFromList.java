package testapp;

import java.util.Arrays;
import java.util.List;

public class StreamFromList {

	public static void main(String[] args) {
		// Stream from list, filter and print
		
		List<String> people =Arrays.asList("Ngawang", "Tsering", "Pema", "Tashi", "Dolma", "Tsewang");
         people.stream()
         .map(String::toLowerCase)
         .filter(x->x.startsWith("t"))
         .forEach(System.out::println);
	}
}
