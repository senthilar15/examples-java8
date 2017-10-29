package test.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClazz {

	
	private static void transform(UnaryOperator<Color> op){
		op.apply(new Color());
	}
	
	
	private static <X, Y, Z >void transform(ColorTransformer<X, Y, Color, Z> op, X x , Y y){
		op.transform(x, y, new Color());
	}
	
	private static <X, Y, Z > void transform1(ColorTransformer<Color, X, Y, Z> op, X x , Y y){
		op.transform(new Color(),x, y);
	}
	
	
	private static <T, R> void transform( BiFunction<Color, T ,R > op, T arg){
		R i = op.apply(new Color(), arg);
		R ss =i;
		
	}
	
	private static UnaryOperator<Color>  brighten(int factor){
		return c -> c.brighten(factor);
	}
	
	private static UnaryOperator<Color>  brighter(){
		return c -> c.brighter();
	}
	
	private static int  brighter(int c){
		return  c;
	}

	
	
	public static void main(String[] args) {

         try{
        	 
           
        	 String s[] = new String[] {"Mango", "Apple","apple","orange"};
        	 
        	 Arrays.sort(s, (e,f) -> e.compareToIgnoreCase(f));
        	 
        	 Stream.of(s).forEach(System.out::println);
        	 
        	 Arrays.sort(s, String::compareToIgnoreCase);
        	 
        	 Stream.of(s).forEach(System.out::println);
        	 
        	 BiFunction<String, String, Integer> fun1 =  String::compareToIgnoreCase;  //  (f, ss) -> Integer.compare(f.length(), ss.length());
        	
        	 BiFunction<String, String, Integer> fun2 = (s1, s2) -> s1.compareToIgnoreCase(s2);// String::compareToIgnoreCase;
        	
        	 BiFunction<String, String, Integer> fun = (f, ss) -> Integer.compare(f.length(), ss.length());
        	 
        	 BiFunction<Integer, Integer, Integer> fun3 =  Integer::compare; 
        	 
        	 BiFunction<Integer, Integer, Integer> fun4 =  Integer::compareTo; 
        	 
        	 Arrays.sort(s, (f, ss) -> Integer.compare(f.length(), ss.length()));
        	 
        	 Arrays.sort(s,comparatorGenerator(fun1)); 
        	 
        	 
        	 Comparator<String> compa = new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
        	 
        	
        	     		
     		BiFunction<Color, Integer,Color> funbi = new BiFunction<Color, Integer,Color >(){

				@Override
				public Color apply(Color arg0, Integer arg1) {
					// TODO Auto-generated method stub
					return null;
				}
     			
     		};
     		
     		Predicate<String> p = e->e.startsWith("A") ;
     		p.and(e->e.startsWith("a"));
     		
        	
     		 Stream<String> stream =  Stream.of(s); 
     		 Set<Character> chars = stream.filter(p.or(e->e.startsWith("a")))
     				                       .map( e -> e.charAt(0))
     				                       .collect(Collectors.<Character>toSet());
        	
        	 
        	
        	 
        	 
        	 UnaryOperator<Color> funn =   new UnaryOperator<Color>() {

      			@Override
      			public Color apply(Color arg0) {
      				// TODO Auto-generated method stub
      				return arg0.brighter();
      			}
      		};
      		 transform(funn);
      		 
      		 UnaryOperator<Color> cf0= Color::brighter; 
      		 
      		
      		 transform(cf0);
      	 	  
        	 UnaryOperator<Integer> cf = MainClazz::brighter;
        	 
        	 BiFunction<Double, Double, Double> pow = Math::pow;
        	 
        	// transform(cf);
        	 
        	 transform(Color::brighten, 1);
        	 
        	 transform((c ,i) -> c.brighten(i), 1);
        	 
        	 transform((c ,i) -> c.brighter(i), new Color());
        	 	
        	 transform(brighter());
        	 
        	 transform(brighten(1));
        	 
        	 brighter().apply(new Color());
        	 
        	 brighten(1).apply(new Color());
        	 
        	 transform((x, y , c) -> c.transform(x, y) , 1 ,2);
        	 
        	 transform1(Color::transform,1,2);
        	 
        	 
        	
        	Stream<Stream<String>> stringStream =  Stream.iterate(1, e->e*2).limit(10).map(e -> callMe(e)).map(e -> anthorStream(e));
        	
        	Stream<String> flatStream =  Stream.iterate(1, e->e*2).limit(10).map(e -> callMe(e)).flatMap(e -> anthorStream(e));
        	
        	//stringStream.forEach(i -> {System.out.println("########");; i.forEach(System.out::println);});
        	
        	//flatStream.forEach(System.out::println);
        	
        	
        	/* Stream.iterate(0, i -> i + 1)
        	 		.flatMap(i -> Stream.of(4, 5, 6, 7))
        	 		.map(i -> callMe(i))
        	 		.peek(i -> System.out.println("Map: " + i))
        	 		.limit(5)
        	 		.forEach(i -> {});

       System.out.println();
       System.out.println();

       Stream.iterate(0, i -> i + 1)
             .flatMap(i -> Stream.of(i, i, i, i))
             .limit(5)
             .map(i -> i + 1)
             .peek(i -> System.out.println("Map: " + i))
             .forEach(i -> {});*/
        	 
        	       	 
         }catch(Exception e){
        	 e.printStackTrace();
         }

	}



	private static Stream<String> anthorStream(String e) {
		// TODO Auto-generated method stub
		return Stream.of("a","b","c","d","e","g");
	}


	private static String callMe(Integer i) {
		//System.out.println("Map: " + i);
		return String.valueOf(i);
	}
	
	private static <T ,R extends Integer>  Comparator<T> comparatorGenerator(BiFunction<T, T, R> fun){
		
		return new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return fun.apply(o1, o2);
			}
		};
		
	}

}
