import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.*;

public class Event{
String name;
String room;
String season;
int[] hours;
public Event(String n, String r, String s, int[] h){
	name=n;
	room=r;
	season=s;
	hours=h;
}


public void Create(){
	BufferedWriter bw = null;
	System.out.println("test message");
	try{
		bw = new BufferedWriter(new FileWriter("Events.txt", true));
		
		//writing requested events to the text file
		String time1=Arrays.toString(hours);
		bw.write(this.room+"||"+this.name+"||"+this.season+"||"+time1);
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

	
}