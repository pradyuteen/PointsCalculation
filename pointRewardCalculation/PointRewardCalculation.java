package pointRewardCalculation;

public class PointRewardCalculation {
	public int rewardCalculation(int amount){
		int points = 0;
		int remainder = 0; 
		
		if(amount < 50) {
			points = 0;
		}
		else if (amount > 50 && amount < 100) {
			points = amount - 50;
		}
		else if (amount > 100) {
			points = amount - 100;
			
			if(amount%100 != 0 && amount%100 > 50) {
				remainder = amount%100;
				points = points + (remainder - 50);
			}
		}
		return points;
	}
}
