package learnjava8;

import java.util.Arrays;
import java.util.List;

public class Java8Stream {

	
	public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        
        List<Person> resultq = Arrays.asList(
        		new Person("ngawang", 56),
        		new Person("sonam", 26),
        		new Person("yemam", 24)
        		);
        
        
        Person lasho =resultq.stream().filter((per)
        		->"ngawang".equals(per.getName()) && 56 ==per.getAge()).findAny().orElse(null);
        System.out.println("result q " +lasho);
        
        
        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);
        
        
        
        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        
        System.out.println("name : " + name);

    }



}
