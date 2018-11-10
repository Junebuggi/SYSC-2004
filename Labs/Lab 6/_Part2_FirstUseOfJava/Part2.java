package _Part2_FirstUseOfJava.util.HashMap;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Part2 {

	public static void main (String[] args) {
	
		HashMap<Integer, String> gradebook = new HashMap<Integer, String>();
		Random random = new Random();
		
		String grades[] = {"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"};
		
		for(int i = 0; i < 1000; i++) {
			int number = random.nextInt(10000);
			if(gradebook.containsKey(number)) i--;
			int gpa = random.nextInt(12);
			gradebook.put(number,grades[gpa]);
		}
		
		System.out.println(gradebook.size());
		
		Set<Integer> keys = gradebook.keySet();
		for (Integer stNum: keys) {
		String grade = (String) gradebook.get(stNum);
		System.out.println(stNum + " = " + grade);
		}
		

	}

}
