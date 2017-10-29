package test.examples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
		try{
			
			Path path = Paths.get(StreamExample.class.getResource("/test/examples/stream-provider").toURI());
			Files.readAllLines(path).stream()
					                  .flatMap(StreamExample::splitWords)
					                  .peek(System.out::println)
					                  .forEach(i -> {});  
			 
			Set<String> set = Files.readAllLines(path).stream()
                                     .map(StreamExample::splitWords)
                                     .flatMap(i ->i)
                                     .peek(System.out::println)
                                     .collect(Collectors.toSet()) ;
			
				Set<String> set2 = new HashSet<>();
					
				Stream.generate(Math::random)
				            .filter(r  -> r * 10 > 1 && r * 10 < 3)
				            .map(r -> r * 10)
				            .map(Math::ceil)
				            .map(Math::round)
				            .limit(10)
				           // .peek(System.out::println)
				            .forEach(i -> {});  ;
				            
				            
			Stream.generate(Math::random)
				            .map(r  -> {
				            if(r * 10 > 1 && r * 10 < 3)
				            	return r;
				            else
				               return 0.0d;})
				            .filter(e ->( (double)e > 0))
				            .limit(10)
				            //.peek(System.out::println)
				            .forEach(i -> {});  
			
			
			
			Comparator<String> c1 = new Comparator<String>() {
		
				@Override
				public int compare(String o1, String o2) {
					
					
					
					return 0;
				}
			};
			
			Comparator<String> c = Comparator.comparing(s -> s.endsWith("s")); 
			
			Comparator<String> c2 = Comparator.comparing(String::length); 
		
			Optional<Double> sqroot = inverse(2).flatMap(StreamExample::sqroot);
			
		 	set.stream().mapToInt(String::length).reduce(Integer::sum).ifPresent(System.out::println);
		 	
		 	set.stream().map(String::length).reduce(Integer::sum).ifPresent(System.out::println);
		 	
		 	int outut = set.stream().map(String::length).reduce( 0 ,Integer::sum  , (a, a1) -> a + a1);
		 	
		 
		 	String concat = set.stream().filter(e -> e.startsWith("s"))
		 			                    .peek(System.out::println)
		 			                    .reduce( "" , (a, b) -> a + b+ " "  , (a, a1) -> "  " +a +a1);
		 	
		 	System.out.println(concat);
		 	
		 	
		   // System.out.println(set.stream().mapToInt(String::length).sum());
			
			//set.stream().reduce(String::concat).ifPresent(l -> System.out.println(l.length()));
			
		//	set.stream().map(String::length).collect(Collectors.averagingDouble(d1 -> (double)d1));
					
		 	
		 	
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	private static Stream<String> splitWords(String line){
		
		return Stream.of(line.split("\\s+"));
	}
	
	
	private static Optional<Double> inverse(double d){
		
		return (d < 0) ? Optional.empty() : Optional.of(1/d);
	}
	
   private static Optional<Double> sqroot(double d){
		
		return (d < 0) ? Optional.empty() : Optional.of(Math.sqrt(d));
	}

}
