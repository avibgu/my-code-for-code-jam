package main;

public class Num {

	private int[] num;
	
	private int length;
	
	public Num(String string) {
		
		this.length = string.length();
		
		this.num = new int[ this.length ];
		
		for(int i=0; i < length; i++){
			
			this.num[i] = Integer.valueOf( string.charAt(i) ) - '0';
		}
	}
	
	public String toString(){
		
		String ans = "";
		
		for(int i=0; i < length; i++){
			
			ans = ans + this.num[i];
		}
		
		return ans;
	}

	public boolean biggerThan(Num temp) {
		// TODO Auto-generated method stub
		return false;
	}

	public Num pahot(Num num2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void plus(Num x) {
		// TODO Auto-generated method stub
		
	}
}
