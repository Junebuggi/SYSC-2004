package _Part3_HarshLessonsInHashMaps;

public class Patient {

	private int ohipNumber;
	private String surname;
	private String firstName;
	/**
	 * 
	 * @param ohipNumber
	 * @param firstName
	 * @param surname
	 */
	public Patient(int ohipNumber, String firstName, String surname) {
		this.ohipNumber = ohipNumber;
		this.surname = surname;
		this.firstName = firstName;
	}
	
	public int getOhipNumber() {
		return this.ohipNumber;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String toString() {
		String s = "";
		s = surname + ", " + firstName + " Ohip Number: " + ohipNumber;
		return s;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		Patient p = (Patient) o;
		if(this.ohipNumber == p.ohipNumber && this.surname.equals(p.surname) 
		&& this.firstName.equals(p.firstName)) return true;
		
		return false;
				
	}
}
