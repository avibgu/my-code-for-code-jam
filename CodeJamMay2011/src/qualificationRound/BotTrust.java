package qualificationRound;

public class BotTrust {

	public static int calcSeconds(int n, String[] input){
		
		int seconds = 0;
		int blueStepTime = 0;
		int orangeStepTime = 0;
		int blueIdx = 1;
		int orangeIdx = 1;
		int orangeBuf = 0;
		int blueBuf = 0;
		
		for (int j=1; j <= n*2; j+=2){
			
			String Rj = input[j];
			int Pj = Integer.parseInt( input[j+1] );

			if (Rj.equals("B")){
				
				blueStepTime += Math.abs(blueIdx - Pj) + 1 ;//- blueBuf;
				
				blueIdx = Pj;
				
				if ( blueStepTime > orangeStepTime ){
					
					orangeStepTime = 0;
				}
//				else
//					blueBuf++;
//				
//				orangeBuf = 0;
			}
			else{
				
				orangeStepTime += Math.abs(orangeIdx - Pj) + 1 ;//- orangeBuf;
				
				orangeIdx = Pj;
				
				if ( orangeStepTime > blueStepTime ){
					
					blueStepTime = 0;
				}
//				else
//					orangeBuf++;
//				
//				blueBuf = 0;
			}
		}
		
		seconds += blueStepTime + orangeStepTime;
		
		return seconds;
	}
}
