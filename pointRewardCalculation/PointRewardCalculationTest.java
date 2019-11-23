package pointRewardCalculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsRewardCalculationTest {
	
	public String firstCustomer(){
		String result = "";
		PointRewardCalculation pointRewards = new PointRewardCalculation();
		int rewardPoints = pointRewards.rewardCalculation(575);
		
		if (rewardPoints == 975) {
			result = "First customer points calculated correctly!";
		}
		else {
			result = "First customer points calculated incorrectly. Need to try again! ";
		}
		return result;
	}
	
	public List<String> secondCustomer() {
		List<String> result = new ArrayList<String>();
		
		HashMap<String, List<Integer>> map = new HashMap<>();
		List<Integer> january = new ArrayList<Integer>();
		january.add(75); //25 points
		january.add(950); //1700 points
		january.add(855); //1560 points
		january.add(25); //0 points
		january.add(50); //0 points
		january.add(85); //35 points
		january.add(505); //960 points
		january.add(-500); //0 points
		
		List<Integer> february = new ArrayList<Integer>();
		february.add(85); //35 points
		february.add(20); //0 points
		february.add(65); //15 points
		february.add(-25); //0 points
		february.add(300); //450 points
		february.add(205); //260 points
		february.add(795); //1440 points
		
		List<Integer> march = new ArrayList<Integer>();
		march.add(250); //350 points
		march.add(650); //1150 points
		march.add(95); //45 points
		march.add(20); //0 points
		march.add(500); //800 points
		march.add(100); //50 points
		
		map.put("January", january);
		map.put("February", february);
		map.put("March", march);
		
//		System.out.println(map);
		
		PointRewardCalculation pointRewards = new PointRewardCalculation();
		Map<String,Integer> finalMap = pointRewards.threeMonthRewardCalculation(map);
//		System.out.println(finalMap);
		for(Map.Entry<String,Integer> entry : finalMap.entrySet()) {
//			System.out.println("The total points for " + entry.getKey() + " is " + entry.getValue());
			result.add("The total points for " + entry.getKey() + " is " + entry.getValue());
		}
		
		return result;
	}
}
