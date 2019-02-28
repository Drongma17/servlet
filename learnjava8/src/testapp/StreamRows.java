package testapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRows {

	public static void main(String[] args)throws IOException {
	  // Stream row from text file, sort, and print
		
		Stream<String> bands =Files.lines(Paths.get("send file url here "));
		bands
		.sorted()
		.filter(x->x.length()>13)
		.forEach(System.out::println);
		bands.close();
	}
}
