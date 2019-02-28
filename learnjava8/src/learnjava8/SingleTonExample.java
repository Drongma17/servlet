package learnjava8;

public class SingleTonExample {

	
	private static SingleTonExample developer =null;
	
	private SingleTonExample(){
	
	}
	
	
	public static SingleTonExample getTone(){
		if(developer == null){
			developer = new SingleTonExample();
		}
	    return developer;
	}
}
