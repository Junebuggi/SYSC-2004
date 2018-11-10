package lab7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Lab7a {

	public static void main(String[] args) throws IOException  {
		
			FileReader file = null;
			try {
				file = new FileReader("sampleCSV.csv");
				BufferedReader reader = new BufferedReader(file);
				ArrayList<Row> txt = new ArrayList<>();
				String line = reader.readLine();;
			

				while (line != null) {
					String[] column = line.split(",");
					Row rows = new Row(column.length);
					for(int i = 0; i < column.length; i++) {
						rows.add(i, column[i]);
					}
					txt.add(rows);	
					line = reader.readLine();
		
				}
				
				for(int i = 0; i < txt.size(); i++ ) {
					System.out.println(txt.get(i).toString());
				}
				
				
			
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}

	}

class Row { //No public
	private String[] columns;
	
	public Row(int numColumns) {
		columns = new String[numColumns];
	}
	
	public void add(int column, String value) {
		columns[column] = value;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < columns.length - 1; i++) {
			s += columns[i] + ", ";
		}
		return s + columns[columns.length-1];
	}
	
	
} 

