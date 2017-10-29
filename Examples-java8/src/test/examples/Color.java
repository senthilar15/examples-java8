package test.examples;

public class Color {
	
	public  Color brighter(){
		System.out.println("Brighter");
		return new Color();
	}
	
	
	public  Color brighter(Color c){
		
		System.out.println("Brighter called");
		return new Color();
	}
		
	public Color brighten(int factor){
		
		System.out.println("Brighten called");
		return new Color();
	}
	
	/*public Integer brighten(int factor){
		
		System.out.println("Brighten called");
		return 1;
	}
	 */
	public Color transform(int x , int y){
		
		System.out.println("trasform called");
		return new Color();
	}
  
    @Override
	public String toString(){
    	return "Black Red Black Green";
    }

}
