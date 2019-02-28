package appti;

public class DecimalToHexa {
	
	public static void main(String[] args) {
		
		
		int num=178; 
		String hex="";
		
		
		
		while(num!=0){
			int r=num%16;
			if(r<=9)
				hex=r+hex;
			else
				hex=(char)(r+55)+hex;
			num =num/16;
		}
		System.out.println(hex);
	}

}
