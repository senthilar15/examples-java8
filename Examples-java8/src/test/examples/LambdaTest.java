package test.examples;

import java.util.stream.Stream;

public class LambdaTest {

	public static void main(String[] args) {
		
		
		Stream<Integer> intStream =  Stream.of(1,2,3,4,5,6);
		
		intStream.forEach(System.out::println);
		
	}

}
