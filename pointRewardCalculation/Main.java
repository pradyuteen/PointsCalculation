package pointRewardCalculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstCustomer());
		System.out.println(secondCustomer());
	}
	
	public static Map<String,Integer> threeMonthRewardCalculation(HashMap<String,List<Integer>> monthlyTransactions){
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
	
	public static int rewardCalculation(int amount){
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
	
	public static String firstCustomer(){
		String result = "";
		int rewardPoints = rewardCalculation(575);
		
		if (rewardPoints == 1000) {
			result = "First customer points calculated correctly with one transaction in the past 3 months!";
		}
		else {
			result = "First customer points calculated incorrectly. Need to try again! ";
		}
		return result;
	}
	
	public static String secondCustomer() {
		String finalResult = "";
		
		HashMap<String, List<Integer>> map = new HashMap<>();
		List<Integer> january = new ArrayList<Integer>();
		january.add(75); //25 points
		january.add(950); //1750 points
		january.add(855); //1560 points
		january.add(25); //0 points
		january.add(50); //0 points
		january.add(85); //35 points
		january.add(505); //860 points
		january.add(-500); //0 points
		//Total points for January is 4230 points
		
		List<Integer> february = new ArrayList<Integer>();
		february.add(85); //35 points
		february.add(20); //0 points
		february.add(65); //15 points
		february.add(-25); //0 points
		february.add(300); //450 points
		february.add(205); //260 points
		february.add(795); //1440 points
		//Total points for February is 2200 points
		
		List<Integer> march = new ArrayList<Integer>();
		march.add(250); //350 points
		march.add(650); //1150 points
		march.add(95); //45 points
		march.add(20); //0 points
		march.add(500); //800 points
		march.add(100); //50 points
		//Total points for March is 2395 points
		
		map.put("January", january);
		map.put("February", february);
		map.put("March", march);

		Map<String,Integer> finalMap = threeMonthRewardCalculation(map);

		for(Map.Entry<String,Integer> entry : finalMap.entrySet()) {
			System.out.println("The total points for " + entry.getKey() + " is " + entry.getValue());
		}	
		if (finalMap.get("January") == 4230 && finalMap.get("February") == 2200 && finalMap.get("March") == 2395 && finalMap.get("all of the months") == 8825) {
			finalResult = "Second customer points calculated correctly for the past 3 months!";
		}
		else {
			finalResult = "Second customer points calculated incorrectly. Need to try again! ";
		}
		return finalResult;
	}
}

