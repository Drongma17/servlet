package testapp;

import java.util.Arrays;

public class StreamArraySort {

	public static void main(String[] args) {
		//Stream from Array, sort, filter and print
		
		String[] names ={"Ngawang", "Tsering", "Pema", "Tashi", "Dolma", "Tsewang"};
		Arrays.stream(names)
		.filter(x->x.startsWith("T"))
		.sorted()
		.forEach(System.out::println);
	}
}
