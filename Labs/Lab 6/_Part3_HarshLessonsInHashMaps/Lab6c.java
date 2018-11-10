package _Part3_HarshLessonsInHashMaps;

import java.util.HashMap;
import java.util.Set;

public class Lab6c {

	public static void main(String[] args) {
		HashMap<String, Patient> hospital = new HashMap<String, Patient>();
		
		Patient p = new Patient(1, "John", "Doe");
		hospital.put("C123", p);
		
		
		Set<String> keys = hospital.keySet();
		for (String roomNum: keys) {
		if(hospital.get(roomNum).equals(p) ) // Originally only returned true for shallow copy
		System.out.println(roomNum);
		}
		
		Patient other = new Patient(1, "John", "Doe");
		
		Set<String> rooms = hospital.keySet();
		for (String roomNum: rooms) {
		if(hospital.get(roomNum).equals(other) )
		System.out.println(roomNum);
		}
		
		System.out.println(hospital.hashCode());
		
	}

}
