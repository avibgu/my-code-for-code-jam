package qualificationRound;

public class BotTrust {

	public static int calcSeconds(int n, String[] input){
		
		int seconds = 0;
		int blueStepTime = 0;
		int orangeStepTime = 0;
		int blueIdx = 1;
		int orangeIdx = 1;
		
		for (int j=1; j <= n*2; j+=2){
			
			String Rj = input[j];
			int Pj = Integer.parseInt( input[j+1] );

			if (Rj.equals("B")){
				
				blueStepTime += Math.abs(blueIdx - Pj) + 1 ;
				
				blueIdx = Pj;
				
				if ( blueStepTime <= orangeStepTime ){
					
					seconds += orangeStepTime + 1;	
					blueStepTime = 0;
				}
				
				orangeStepTime = 0;
			}
			else{
				
				orangeStepTime += Math.abs(orangeIdx - Pj) + 1 ;
				
				orangeIdx = Pj;
				
				if ( orangeStepTime <= blueStepTime ){
					
					seconds += blueStepTime + 1;
					orangeStepTime = 0;
				}
				
				blueStepTime = 0;	
			}
		}
		
		seconds += blueStepTime + orangeStepTime;
		
		return seconds;
	}
}
