package testapp;

import java.io.IOException;
import java.util.stream.IntStream;

public class JavaStream {

	
	public static void main(String[] args) throws IOException{
		IntStream
		.range(1, 10)
		.forEach(System.out::print);
		System.out.println();
	}
}
