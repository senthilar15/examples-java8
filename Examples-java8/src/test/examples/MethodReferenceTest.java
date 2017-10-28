package test.examples;

import java.util.function.UnaryOperator;

public class MethodReferenceTest {

	public MethodReferenceTest(){
		
	}
	
	
	public void callMe(){
		System.out.println("Called callMe");
		UnaryOperator<Integer> unary = this::callMe2;
	}
	
	public Integer callMe2(int i){
		System.out.println("Called callMe2");
		return i; 
	}
	
	public static void main(String[] args) {
		
		MethodReferenceTest test = new MethodReferenceTest();
		test.callMe();

	}

}
