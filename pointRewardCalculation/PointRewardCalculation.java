package pointRewardCalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointRewardCalculation {
	public Map<String,Integer> threeMonthRewardCalculation(HashMap<String,List<Integer>> monthlyTransactions){
		int points = 0;
		int totalPoints = 0;
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(Map.Entry<String, List<Integer>> entry : monthlyTransactions.entrySet()) {
			List<Integer> valueSet = entry.getValue();
			for(int i = 0; i < valueSet.size(); i++) {
				points = points + rewardCalculation(valueSet.get(i));
			}
			map.put(entry.getKey(), points);
			totalPoints = totalPoints + points;
			points=0;
		}
		map.put("all of the months", totalPoints);
		
		return map;
	}
	
	public int rewardCalculation(int amount){
		int points = 0;
		
		if(amount <= 50) {
			points = 0;
		}
		else if (amount > 50 && amount < 100) {
			points = amount - 50;
		}
		else if (amount > 100) {
			points = (amount - 100)*2;
			points = points + 50;
		}
		return points;
	}
}
