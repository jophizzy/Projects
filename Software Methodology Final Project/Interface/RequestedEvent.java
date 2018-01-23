import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.*;

public class RequestedEvent{
String name;
String room;
boolean winter;
boolean fall;
boolean spring;
boolean summer;
int slots;
TimeSlot[] timeSlots;
public RequestedEvent(String n, String r, boolean w, boolean f,
		boolean sp, boolean su,int sl, TimeSlot[] ts ){
	name=n;
	room=r;
	winter=w;
	fall=f;
	spring=sp;
	summer=su;
	slots=sl;
	timeSlots=ts;
	
}


public void Create(){
	BufferedWriter bw = null;
	try{
		bw = new BufferedWriter(new FileWriter("RequestedEvents.txt", true));
		
		//writing requested events to the text file
		String t1=timeSlots[0].getDay();
		String time1=Arrays.toString(timeSlots[0].getTime());
		String t2=timeSlots[1].getDay();
		String time2=Arrays.toString(timeSlots[1].getTime());
		String t3=timeSlots[2].getDay();
		String time3=Arrays.toString(timeSlots[2].getTime());
		String t4=timeSlots[3].getDay();
		String time4=Arrays.toString(timeSlots[3].getTime());
		String t5=timeSlots[4].getDay();
		String time5=Arrays.toString(timeSlots[4].getTime());
		
		
		
		bw.write(this.room+"||"+this.name+"||"+this.winter+"||"+this.spring
				+"||"+this.summer+"||"+this.fall+"||"+this.slots+"||"+t1+"||"+time1+"||"+t2
				+"||"+time2+"||"+t3+"||"+time3+"||"+t4+"||"+time4+"||"+t5+"||"+time5);
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
