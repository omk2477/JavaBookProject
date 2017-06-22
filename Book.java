package ÀÌ½ÂÀ±30219;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Book {
	String[][] output;

	Date date = new Date();
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public Book(){
		try {
			ArrayList<String> arr = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("C:/test/30219_ÀÌ½ÂÀ±.txt"));
			
			String str = null;
			
			while((str = br.readLine()) != null){
				arr.add(str);
			}
			
			output = new String[arr.size()][4];
			
			for(int i = 0; i < arr.size(); i++){
				String[] split = arr.get(i).split("	");
				for(int j = 0; j < split.length; j++){
					output[i][j] = split[j];
				}
			}
			
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	String data = "";
	
	public String[] getter(int index){
		if(index != 0){
			return output[index];
		}
		return null;
	}
	
	public void setter(String[] data){
		this.data += data[0] + "\t";
		this.data += data[1] + "\t";
		this.data += data[2] + "\t";
		this.data += format.format(date);
	}
}
