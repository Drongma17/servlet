package learnjava8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class JavaStream {

	public static void main(String[] args) throws IOException {
		//1. 
//		IntStream
//		   .range(1, 10)
//		   .forEach(System.out::print);
//		System.out.println();
		
		
		
		//2. Integer stream with skip
//		IntStream
//		   .range(1, 10)
//		   .skip(5)
//		   .forEach(x->System.out.println(x));
//		System.out.println();
		
		
		
		//3. Integer stream with sum
//		System.out.println(
//				IntStream
//				   .range(1, 10)
//				   .sum());
//		System.out.println();
//		
		
		
		//4. Stream.of, sorted and findfirst
//		Stream.of("Ava", "Aneri", "Alberto")
//		.sorted()
//		.findFirst()
//		.ifPresent(System.out::println);
//		
		
		
		//5. Stream from Array, sort, filter and print
//		String[] name={"ngawang", "Tsering", "Sonam", "Dawa", "Kalsang", "Phurbu", "Norbu", "Sangmo", "Sorig"};
//		Arrays.stream(name)
//		.filter(x->x.startsWith("S"))
//		.sorted()
//		.forEach(System.out::println);
//		
		
		//6. average of square of an int array
//		Arrays.stream(new int[]{2, 4, 8, 10})
//		.map(x->x*x)
//		.average()
//		.ifPresent(System.out::println);
//		
		
		
		//7. stream from list, filter and print
//		List<String> people =Arrays.asList("ngawang", "Tsering", "Sonam", "Dawa", "Kalsang", "Phurbu", "Norbu", "Sangmo", "Sorig");
//		people
//		  .stream()
//		  .map(String::toLowerCase)
//		  .filter(x->x.startsWith("s"))
//		  .forEach(System.out::println);
		
		//8. stream rows from text file, sort, filter, and print
//		Stream<String> bands=null;
//		try {
//			bands = Files.lines(Paths.get("bands.txt"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		bands
//		.sorted()
//		.filter(x->x.length()>13)
//		.forEach(System.out::println);
//		bands.close();
		
		
		//9. stream rows from text file and save to list
//		Stream<String> band2=null;
//		try {
//			band2 = Files.lines(Paths.get("bands.txt"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		band2
//		.filter(x->x.contains("it"))
//		.collect(Collectors.toList());
//		band2.forEach(x->System.out.println(x));
//		band2.close();
//		
		
		//10. stream rows from CSV file and count
//         Stream<String> rows1=null;
//		try {
//			rows1 = Files.lines(Paths.get("data.txt"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//         int rowCount =(int)rows1
//        		 .map(x->x.split(","))
//        		 .filter(x->x.length == 3)
//        		 .count();
//         System.out.println(rowCount+"rows");
//         rows1.close();
		
		//11. stream rows from CSV file and pass data from rows
//      Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
//		
//       rows2
//     		 .map(x->x.split(","))
//     		 .filter(x->x.length == 3)
//     		 .filter(x->Integer.parseInt(x[1])>13)
//     		 .forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
//         rows2.close();
//		
		
	
	}
}
