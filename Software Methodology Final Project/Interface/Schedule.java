import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.*;

public class Schedule{
String room;
String season;
int[] monday;
int[] tuesday;
int[] wednesday;
int[] thursday;
int[] friday;
int[] saturday;
int[] sunday;

	//add priority and recurring events later
	public Schedule(String r, String s, int[] mon, int[] tue,
			int[] wed, int[] thu, int[] fri, int[] sat, int[] sun){
		room=r;
		season=s;
		monday=mon;
		tuesday=tue;
		wednesday=wed;
		thursday=thu;
		friday=fri;
		saturday=sat;
		sunday=sun;
		
	}
	
	public Schedule(String r, String s){
		room=r;
		season=s;	
	}
	
	
	public void Create(){
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter("Schedules.txt", true));
			//writing events to the text file
			String t1=Arrays.toString(monday);
			String t2=Arrays.toString(tuesday);
			String t3=Arrays.toString(wednesday);
			String t4=Arrays.toString(thursday);
			String t5=Arrays.toString(friday);
			String t6=Arrays.toString(saturday);
			String t7=Arrays.toString(sunday);
			
			bw.write(this.room+"||"+this.season+"||"+t1+"||"+t2+"||"+t3
					+"||"+t4+"||"+t5+"||"+t6+"||"+t7);
			
			bw.newLine();
			bw.flush();
		} catch (IOException ioe){
			ioe.printStackTrace();
		} finally {
			if (bw != null) try {
				bw.close();
			}catch (IOException ioe2){
				//ignore
			}
		}
	}	
	
	public String View(){
		
		String match="";
		// The name of the file to open.
        String fileName = "Schedules.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	String[] data = line.split("\\|\\|");
            	System.out.println(data[0]);
            	System.out.println(data[1]);
            	if (data[0].equals(room) && data[1].equals(season)){
            		match=line;
            		System.out.println("test message");
            	}
            		
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return match;
	}
	
}