import java.util.Date;
import java.util.Calendar;
import java.io.*;

public class Event{
	private String name;
	private String room;
	private Calendar date;
	private int length; //minutes
	//add priority and recurring events later
	public Event(String n, String r, Calendar d, int l){
		name = n;
		room = r;
		date = d;
		length = l;
	}
	
	
	//When called, adds the calling event to RequestedEvents.txt
	public void RequestEvent(){
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter("RequestedEvents.txt", true));
			//writing events to the text file
			bw.write(this.name+"~"+this.room+"~");
			int y= this.date.get(Calendar.YEAR);
			int m = this.date.get(Calendar.MONTH);
			int d = this.date.get(Calendar.DAY_OF_MONTH);
			int h = this.date.get(Calendar.HOUR_OF_DAY);
			int min = this.date.get(Calendar.MINUTE);
			bw.write(Integer.toString(y)+":"+Integer.toString(m)+":"+
					Integer.toString(d)+":"+Integer.toString(h)+":"+
					Integer.toString(min));
			bw.write("~"+Integer.toString(this.length));
			
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

	public void addManualEvent(){
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter("Schedule.txt", true));
			//writing events to the text file
			bw.write(this.name+"~"+this.room+"~");
			int y= this.date.get(Calendar.YEAR);
			int m = this.date.get(Calendar.MONTH);
			int d = this.date.get(Calendar.DAY_OF_MONTH);
			int h = this.date.get(Calendar.HOUR_OF_DAY);
			int min = this.date.get(Calendar.MINUTE);
			bw.write(Integer.toString(y)+":"+Integer.toString(m)+":"+
					Integer.toString(d)+":"+Integer.toString(h)+":"+
					Integer.toString(min));
			bw.write("~"+Integer.toString(this.length));
			
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