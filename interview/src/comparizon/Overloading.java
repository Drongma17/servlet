package comparizon;

public class Overloading {

	
	void test(String a){
		System.out.println("This is String a");
	}
	
	
	void test(Object o){
		System.out.println("This is String from object ");
	}
	
	
	
	public static void main(String[] args) {
		Overloading ol = new Overloading();
		ol.test(null);
	}
	
	
}
