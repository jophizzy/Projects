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
import java.io.PrintWriter;
import java.io.IOException;


class ViewSchedule
{
        public ViewSchedule(JFrame parent)//create constructor 
        {	

        	SpringLayout layout = new SpringLayout();
        	//creating JLabels
        	JLabel scheduleRoom = new JLabel("Select Room:");
        	JLabel scheduleSeason = new JLabel("Select Season:");
        	
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
    	 	JButton viewSchedule = new JButton("View Schedule");
        	viewSchedule.setBackground(Color.RED);
        	viewSchedule.setOpaque(true);
        	
        	JPanel p = new JPanel(new SpringLayout());
        	p.setLayout(layout);
        	
        	p.add(scheduleRoom);
        	p.add(scheduleSeason);
        	p.add(comboRoom);
        	p.add(comboSeason);
        	p.add(viewSchedule);
        	
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
        
        	layout.putConstraint(SpringLayout.WEST,viewSchedule , 370, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, viewSchedule, 70, SpringLayout.NORTH, p);
        	
        	JFrame f = new JFrame("View Schedule");
         	f.getContentPane().add(p);
         	f.pack();
         	f.setSize(600, 130);
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
         	
        } 
}
        	
        	
        	