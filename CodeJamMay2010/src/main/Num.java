package main;

public class Num {

	private int[] num;
	
	private int length;
	
	public Num(String string) {
		
		this.length = string.length();
		
		this.num = new int[ this.length+1 ];
		
		for(int i=0; i < length; i++){
			
			this.num[i] = Integer.valueOf( string.charAt(i) ) - '0';
		}
	}
	
	public Num(int[] newNum) {
		
		this.num = newNum;
		this.length = newNum.length;
	}

	public String toString(){
		
		String ans = "";
		
		for(int i=0; i < length; i++){
			
			ans = ans + this.num[i];
		}
		
		return ans;
	}

	public boolean biggerThan(Num temp) {

		if( this.length > temp.length ) return true;
		
		else if( this.length < temp.length ) return false;
		
		else{

			for (int i=0; i < this.length; i++){
				
				if ( this.num[i] > temp.num[i] ) return true;
				
				else if ( this.num[i] < temp.num[i] ) return false;
			}
		}
		
		return false;
	}

	public Num pahot(Num x) {
		
		int[] newNum = new int[ (this.length > x.length) ? this.length : x.length ];
		
		int thisIndex = this.length - 1;
		int xIndex = x.length - 1;
		int newNumIndex = newNum.length - 1;

		while ( thisIndex >= 0 && xIndex >= 0){
			
			newNum[newNumIndex] -= (this.num[thisIndex] - x.num[xIndex]);
			
			if ( newNum[newNumIndex] < 0 ){
				
				newNum[newNumIndex] = this.num[thisIndex-1]*10 + this.num[thisIndex];
				newNum[newNumIndex] -= x.num[xIndex];
				this.num[thisIndex-1] -= 1;
			}

			thisIndex--;
			xIndex--;
			newNumIndex--;
		}
		while ( thisIndex >= 0 ){
			
			newNum[newNumIndex] += this.num[thisIndex];
			
			thisIndex--;
			newNumIndex--;
		}
		while ( xIndex >= 0){
			
			newNum[newNumIndex] +=  x.num[xIndex];
			
			xIndex--;
			newNumIndex--;
		}
		
		if( newNum[0] == 0){
			
			int[] nnn = new int[ newNum.length - 1 ];
			
			for(int i=0; i < nnn.length; i++){
				
				nnn[i] = newNum[i+1];
			}
			
			return new Num( nnn );
		}
		else{
			
			this.num = newNum;
			this.length = newNum.length;
		}

		return new Num( newNum );
	}

	public void plus(Num x) {
		
		int[] newNum = new int[ (this.length > x.length) ? this.length+1 : x.length+1 ];
		
		int thisIndex = this.length - 1;
		int xIndex = x.length - 1;
		int newNumIndex = newNum.length - 1;

		while ( thisIndex >= 0 && xIndex >= 0){
			
			newNum[newNumIndex] += (this.num[thisIndex] + x.num[xIndex]) % 10;
			newNum[newNumIndex-1] += (this.num[thisIndex] + x.num[xIndex]) / 10;

			thisIndex--;
			xIndex--;
			newNumIndex--;
		}
		while ( thisIndex >= 0 ){
			
			newNum[newNumIndex] += this.num[thisIndex];
			
			thisIndex--;
			newNumIndex--;
		}
		while ( xIndex >= 0){
			
			newNum[newNumIndex] +=  x.num[xIndex];
			
			xIndex--;
			newNumIndex--;
		}
		
		if( newNum[0] == 0){
			
			int[] nnn = new int[ newNum.length - 1 ];
			
			for(int i=0; i < nnn.length; i++){
				
				nnn[i] = newNum[i+1];
			}
			
			this.num = nnn;
			this.length = nnn.length;
		}
		else{
			
			this.num = newNum;
			this.length = newNum.length;
		}
	}
}
