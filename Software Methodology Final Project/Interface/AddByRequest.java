import java.awt.*;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;

class AddByRequest
{
        public AddByRequest(JFrame parent)//create constructor 
        {	

        	SpringLayout layout = new SpringLayout();
        	//creating JLabels
        	JLabel scheduleRoom = new JLabel("Select Room:");
        	JLabel scheduleSeason = new JLabel("Select Season:");
        	JLabel viewReq = new JLabel("View requests:");
        	JLabel viewSched = new JLabel("View schedule:");
        	JLabel eventName = new JLabel("Event Name:");
        	final JTextField name = new JTextField(20);
        	
        	
        	JLabel eventPriority = new JLabel("<html><u>Enter Event Info:</u></html>");
        	JLabel day1 = new JLabel("Select Day:");
        	JLabel startTimeText1 = new JLabel("Start Time (hour):");
        	JLabel endTimeText1 = new JLabel("End Time (hour):");
        	
        	
        	JComboBox<String> comboDay1 = new JComboBox<String>();
       	 	comboDay1.addItem("Monday");
       	 	comboDay1.addItem("Tuesday");
       	 	comboDay1.addItem("Wednesday");
       	 	comboDay1.addItem("Thursday");
       	 	comboDay1.addItem("Friday");
       	 	comboDay1.addItem("Saturday");
       	 	comboDay1.addItem("Sunday");
       	 	
       	 	JComboBox<Integer> startTime1 = new JComboBox<Integer>();
       	 	for(int i=0; i<24; i++){
       	 		startTime1.addItem(i);
       	 	}
       	 	JComboBox<Integer> endTime1 = new JComboBox<Integer>();
       	 	for(int i=0; i<24; i++){
       	 		endTime1.addItem(i);
       	 	}
        	
        	//create combo box objects
       	 	JComboBox<String> comboRoom = new JComboBox<String>();
       	 	comboRoom.addItem("Gymnasium");
       	 	comboRoom.addItem("Auditorium");
       	 	comboRoom.addItem("Cafeteria");
       	 	comboRoom.addItem("Library");
       	 	comboRoom.addItem("Lecture Room");
       	 	//Seasons
       	 	JComboBox<String> comboSeason = new JComboBox<String>();
    	 	comboSeason.addItem("Winter");
    	 	comboSeason.addItem("Spring");
    	 	comboSeason.addItem("Summer");
    	 	comboSeason.addItem("Fall");
    	 	
    	 	//view schedule button
    	 	JButton viewSchedule = new JButton("View");
        	viewSchedule.setBackground(Color.RED);
        	viewSchedule.setOpaque(true);
        	
        	//view requests button
    	 	JButton viewRequest = new JButton("View");
        	viewRequest.setBackground(Color.RED);
        	viewRequest.setOpaque(true);
        	
        	JButton addEvent = new JButton("Add Event");
        	addEvent.setBackground(Color.GREEN);
        	addEvent.setOpaque(true);
        	
        	JPanel p = new JPanel(new SpringLayout());
        	p.setLayout(layout);
        	
        	p.add(scheduleRoom);
        	p.add(scheduleSeason);
        	p.add(comboRoom);
        	p.add(comboSeason);
        	p.add(viewSchedule);
        	p.add(viewRequest);
        	p.add(viewReq);
        	p.add(viewSched);
        	p.add(eventPriority);
        	p.add(startTimeText1);
        	p.add(endTimeText1);
        	p.add(comboDay1);
        	p.add(startTime1);
        	p.add(endTime1);
        	p.add(day1);
        	p.add(addEvent);
        	p.add(name);
        	p.add(eventName);
        	
        	//room
        	layout.putConstraint(SpringLayout.WEST,scheduleRoom , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, scheduleRoom, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, comboRoom, 22, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, comboRoom,22, SpringLayout.EAST, scheduleRoom);
        	
        	//season
        	layout.putConstraint(SpringLayout.WEST,scheduleSeason , 35, SpringLayout.EAST, comboRoom);
        	layout.putConstraint(SpringLayout.NORTH, scheduleSeason, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, comboSeason, 22, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, comboSeason,22, SpringLayout.EAST, scheduleSeason);
        	
        	layout.putConstraint(SpringLayout.WEST,viewSched , 10,SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, viewSched, 65, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,viewSchedule , 20, SpringLayout.EAST, viewSched);
        	layout.putConstraint(SpringLayout.NORTH, viewSchedule, 62, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,viewReq , 30,SpringLayout.EAST, viewSchedule);
        	layout.putConstraint(SpringLayout.NORTH, viewReq, 65, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,viewRequest , 20, SpringLayout.EAST, viewReq);
        	layout.putConstraint(SpringLayout.NORTH, viewRequest, 62, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,eventPriority , 10,SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventPriority, 105, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,day1 , 10,SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, day1, 40, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,comboDay1, 20,SpringLayout.EAST, day1);
        	layout.putConstraint(SpringLayout.NORTH, comboDay1, 36, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,startTimeText1 , 20,SpringLayout.EAST, comboDay1);
        	layout.putConstraint(SpringLayout.NORTH,startTimeText1 , 40, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,startTime1, 20,SpringLayout.EAST, startTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, startTime1, 36, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,endTimeText1 , 20,SpringLayout.EAST, startTime1);
        	layout.putConstraint(SpringLayout.NORTH,endTimeText1 , 40, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,endTime1, 20,SpringLayout.EAST, endTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, endTime1, 36, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,addEvent, 80,SpringLayout.WEST, endTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, addEvent, 80, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,eventName, 10,SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventName, 80, SpringLayout.NORTH, eventPriority);
        	
        	layout.putConstraint(SpringLayout.WEST,name , 20,SpringLayout.EAST, eventName);
        	layout.putConstraint(SpringLayout.NORTH,name , 80, SpringLayout.NORTH, eventPriority);
        
        	
        	
        	JFrame f = new JFrame("View Schedule");
         	f.getContentPane().add(p);
         	f.pack();
         	f.setSize(700, 230);
         	f.setVisible(true);
         	
         	//action listener for creating schedule
            viewSchedule.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                
            	String room = comboRoom.getSelectedItem().toString();
            	String season = comboSeason.getSelectedItem().toString();
            	Schedule newSched = new Schedule(room,season);
            	
   
            	String results;
            	

            	results=newSched.View();
            	
            	
            	
            	String[] data = results.split("\\|\\|");
            	
            	List<Integer> monHours = new ArrayList<Integer>();
            	String monData=data[2];
            	for (int i=0; i<71; i++){
            		if (monData.substring(i,i+1).equals("1"))
            			monHours.add((i-1)/3);
            	}
            	List<Integer> tueHours = new ArrayList<Integer>();
            	String tueData=data[3];
            	for (int i=0; i<71; i++){
            		if (tueData.substring(i,i+1).equals("1"))
            			tueHours.add((i-1)/3);
            	}
            	List<Integer> wedHours = new ArrayList<Integer>();
            	String wedData=data[4];
            	for (int i=0; i<71; i++){
            		if (wedData.substring(i,i+1).equals("1"))
            			wedHours.add((i-1)/3);
            	}
            	List<Integer> thuHours = new ArrayList<Integer>();
            	String thuData=data[5];
            	for (int i=0; i<71; i++){
            		if (thuData.substring(i,i+1).equals("1"))
            			thuHours.add((i-1)/3);
            	}
            	List<Integer> friHours = new ArrayList<Integer>();
            	String friData=data[6];
            	for (int i=0; i<71; i++){
            		if (friData.substring(i,i+1).equals("1"))
            			friHours.add((i-1)/3);
            	}
            	List<Integer> satHours = new ArrayList<Integer>();
            	String satData=data[7];
            	for (int i=0; i<71; i++){
            		if (satData.substring(i,i+1).equals("1"))
            			satHours.add((i-1)/3);
            	}
            	List<Integer> sunHours = new ArrayList<Integer>();
            	String sunData=data[8];
            	for (int i=0; i<71; i++){
            		if (sunData.substring(i,i+1).equals("1"))
            			sunHours.add((i-1)/3);
            	}
            	
            
                //Displaying message and clearing text fields
                JOptionPane.showMessageDialog(f.getComponent(0), data[0]+" available times: ("+data[1]+")\n"
                		+"Monday: "+monHours+"\n"+"Tuesday: "+tueHours+"\n"
                		+"Wednesday: "+wedHours+"\n"+"Thursday: "+thuHours+"\n"
                		+"Friday: "+friHours+"\n"+"Saturday: "+satHours+"\n"
                		+"Sunday: "+sunHours+"\n");

            }
   
        });
            
            
        addEvent.addActionListener(new ActionListener() {

              public void actionPerformed(ActionEvent arg0) {
            	String reqName = name.getText();
              	String room= comboRoom.getSelectedItem().toString();
            	String season= comboSeason.getSelectedItem().toString();
              	int s1 = (Integer) startTime1.getSelectedItem();
              	int e1 = (Integer) endTime1.getSelectedItem();
              	
              	int [] array1 = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=s1 && i<=e1 && (s1!=e1))
            			array1[i]=1;
            		else
            			array1[i]=0;
            	}
            	Event newEvent=new Event(reqName, room, season, array1);
            	
            	newEvent.Create();
            	
            	JOptionPane.showMessageDialog(f.getComponent(0), "Event has been added.");
            	  
            	  
            	  
                	
                }
            });
        
        viewRequest.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
            String room= comboRoom.getSelectedItem().toString();
          	String season= comboSeason.getSelectedItem().toString();
     
          	
          	boolean seasonBool;
          	String match="";
    		// The name of the file to open.
            String fileName = "RequestedEvents.txt";

            // This will reference one line at a time
            String line = null;
            int myInt=0;

            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);

                
                while((line = bufferedReader.readLine()) != null) {
                	String[] data = line.split("\\|\\|");
                	if (season.equals("Winter")){
                		myInt=2;
                			
                	}
                	if (season.equals("Spring")){
                		myInt=3;
                			
                	}
                	if (season.equals("Summer")){
                		myInt=4;
                			
                	}
                	if (season.equals("Fall")){
                		myInt=5;
                			
                	}
                		
                	if (data[0].equals(room) && data[myInt].equals("true")){
                		
                		List<Integer> monHours = new ArrayList<Integer>();
                    	String monData=data[8];
                    	for (int i=0; i<71; i++){
                    		if (monData.substring(i,i+1).equals("1"))
                    			monHours.add((i-1)/3);
                    	}
                    	List<Integer> tueHours = new ArrayList<Integer>();
                    	String tueData=data[10];
                    	for (int i=0; i<71; i++){
                    		if (tueData.substring(i,i+1).equals("1"))
                    			tueHours.add((i-1)/3);
                    	}
                    	List<Integer> wedHours = new ArrayList<Integer>();
                    	String wedData=data[12];
                    	for (int i=0; i<71; i++){
                    		if (wedData.substring(i,i+1).equals("1"))
                    			wedHours.add((i-1)/3);
                    	}
                    	List<Integer> thuHours = new ArrayList<Integer>();
                    	String thuData=data[14];
                    	for (int i=0; i<71; i++){
                    		if (thuData.substring(i,i+1).equals("1"))
                    			thuHours.add((i-1)/3);
                    	}
                    	List<Integer> friHours = new ArrayList<Integer>();
                    	String friData=data[16];
                    	for (int i=0; i<71; i++){
                    		if (friData.substring(i,i+1).equals("1"))
                    			friHours.add((i-1)/3);
                    	}
                		
                		
                		match=match+"Event Name: "+data[1]+"\nPriority 1: "+data[7]+
                				" "+monHours+"\nPriority 2: "+data[9]+
                				" "+tueHours+"\nPriority 3: "+data[11]+
                				" "+wedHours+"\nPriority 4: "+data[13]+
                				" "+thuHours+"\nPriority 5: "+data[15]+
                				" "+friHours+"\n\n";
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
          	
          	JOptionPane.showMessageDialog(f.getComponent(0),"Requested Events:\n\n"+ match);
          	      	
            }  
          }); 
         	
        
        }
}
   