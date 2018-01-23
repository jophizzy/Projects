import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.*;

public class TimeSlot{
String day;
int[] time;
	public TimeSlot(String d, int[] t){
		day=d;
		time=t;
	}
	
	public String getDay(){
		return day;
	}
	public int[] getTime(){
		return time;
	}
}

