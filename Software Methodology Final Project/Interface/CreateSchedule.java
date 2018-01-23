//import statements
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class CreateSchedule
{
        public CreateSchedule(JFrame parent)//create constructor 
        {	

        	SpringLayout layout = new SpringLayout();
        	//creating JLabels
        	JLabel scheduleRoom = new JLabel("Select Room:");
        	JLabel scheduleSeason = new JLabel("Select Season:");
        	JLabel timeSlots = new JLabel("Declare open time slots:");
        	
        	JLabel startTimeText1 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText2 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText3 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText4 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText5 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText6 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText7 =  new JLabel("Start Time (hour):");
        	
        	JLabel endTimeText1 = new JLabel("End Time (hour):");
        	JLabel endTimeText2 = new JLabel("End Time (hour):");
        	JLabel endTimeText3 = new JLabel("End Time (hour):");
        	JLabel endTimeText4 = new JLabel("End Time (hour):");
        	JLabel endTimeText5 = new JLabel("End Time (hour):");
        	JLabel endTimeText6 = new JLabel("End Time (hour):");
        	JLabel endTimeText7 = new JLabel("End Time (hour):");
        	
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
    	 	
    	 	JLabel monday = new JLabel("Monday:");
    	 	JComboBox<Integer> startTimeMon = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeMon.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeMon = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeMon.addItem(i);
    	 	}
    	 	JLabel tuesday = new JLabel("Tuesday:");
    	 	JComboBox<Integer> startTimeTues = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeTues.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeTues = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeTues.addItem(i);
    	 	}
    	 	JLabel wednesday = new JLabel("Wednesday:");
    	 	JComboBox<Integer> startTimeWed = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeWed.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeWed = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeWed.addItem(i);
    	 	}
    	 	JLabel thursday = new JLabel("Thursday:");
    	 	JComboBox<Integer> startTimeThurs = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeThurs.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeThurs = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeThurs.addItem(i);
    	 	}
    	 	JLabel friday = new JLabel("Friday:");
    	 	JComboBox<Integer> startTimeFri = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeFri.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeFri = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeFri.addItem(i);
    	 	}
    	 	JLabel saturday = new JLabel("Saturday:");
    	 	JComboBox<Integer> startTimeSat = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeSat.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeSat = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeSat.addItem(i);
    	 	}
    	    JLabel sunday = new JLabel("Sunday:");
    	    JComboBox<Integer> startTimeSun = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		startTimeSun.addItem(i);
    	 	}
    	 	JComboBox<Integer> endTimeSun = new JComboBox<Integer>();
    	 	for(int i=0; i<24; i++){
    	 		endTimeSun.addItem(i);
    	 	}
    	 	
    	 	//create schedule button
    	 	//create object of JButton
        	JButton createSchedule = new JButton("Create Schedule");
        	createSchedule.setBackground(Color.RED);
        	createSchedule.setOpaque(true);
    	 	
    	 	//Adding to panel
    	 	JPanel p = new JPanel(new SpringLayout());
        	p.setLayout(layout);
        	p.add(scheduleRoom);
        	p.add(timeSlots);
    	 	p.add(scheduleSeason);
        	p.add(comboRoom);
        	p.add(comboSeason);
        	p.add(monday);
        	p.add(startTimeMon);
        	p.add(endTimeMon);
        	p.add(tuesday);
        	p.add(startTimeTues);
        	p.add(endTimeTues);
        	p.add(wednesday);
        	p.add(startTimeWed);
        	p.add(endTimeWed);
        	p.add(thursday);
        	p.add(startTimeThurs);
        	p.add(endTimeThurs);
        	p.add(friday);
        	p.add(startTimeFri);
        	p.add(endTimeFri);
        	p.add(saturday);
        	p.add(startTimeSat);
        	p.add(endTimeSat);
        	p.add(sunday);
        	p.add(startTimeSun);
        	p.add(endTimeSun);
        	p.add(startTimeText1);
        	p.add(endTimeText1);
        	p.add(startTimeText2);
        	p.add(endTimeText2);
        	p.add(startTimeText3);
        	p.add(endTimeText3);
        	p.add(startTimeText4);
        	p.add(endTimeText4);
        	p.add(startTimeText5);
        	p.add(endTimeText5);
        	p.add(startTimeText6);
        	p.add(endTimeText6);
        	p.add(startTimeText7);
        	p.add(endTimeText7);
        	p.add(createSchedule);
        	
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
        
        	
        	
        	layout.putConstraint(SpringLayout.WEST,timeSlots , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, timeSlots, 50, SpringLayout.NORTH, scheduleRoom);
        	
        	
        	//monday
        	layout.putConstraint(SpringLayout.WEST, monday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, monday, 25, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText1, 30, SpringLayout.EAST, monday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText1, 25, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeMon, 22, SpringLayout.EAST, startTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, startTimeMon, 21, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText1, 22, SpringLayout.EAST, startTimeMon);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText1, 25, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeMon, 22, SpringLayout.EAST, endTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, endTimeMon, 21, SpringLayout.NORTH, timeSlots);
        	

        	//tuesday
        	layout.putConstraint(SpringLayout.WEST, tuesday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, tuesday, 65, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText2, 27, SpringLayout.EAST, tuesday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText2, 65, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeTues, 22, SpringLayout.EAST, startTimeText2);
        	layout.putConstraint(SpringLayout.NORTH, startTimeTues, 61, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText2, 22, SpringLayout.EAST, startTimeTues);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText2, 65, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeTues, 22, SpringLayout.EAST, endTimeText2);
        	layout.putConstraint(SpringLayout.NORTH, endTimeTues, 61, SpringLayout.NORTH, timeSlots);
        	
        	//wednesday
        	layout.putConstraint(SpringLayout.WEST, wednesday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, wednesday, 105, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText3, 4, SpringLayout.EAST, wednesday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText3, 105, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeWed, 22, SpringLayout.EAST, startTimeText3);
        	layout.putConstraint(SpringLayout.NORTH, startTimeWed, 101, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText3, 22, SpringLayout.EAST, startTimeWed);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText3, 105, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeWed, 22, SpringLayout.EAST, endTimeText3);
        	layout.putConstraint(SpringLayout.NORTH, endTimeWed, 101, SpringLayout.NORTH, timeSlots);
        	
        	//thursday
        	layout.putConstraint(SpringLayout.WEST, thursday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, thursday, 145, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText4, 20, SpringLayout.EAST, thursday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText4, 145, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeThurs, 22, SpringLayout.EAST, startTimeText4);
        	layout.putConstraint(SpringLayout.NORTH, startTimeThurs, 141, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText4, 22, SpringLayout.EAST, startTimeThurs);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText4, 145, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeThurs, 22, SpringLayout.EAST, endTimeText4);
        	layout.putConstraint(SpringLayout.NORTH, endTimeThurs, 141, SpringLayout.NORTH, timeSlots);
        	
        	//friday
        	layout.putConstraint(SpringLayout.WEST, friday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, friday, 185, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText5, 40, SpringLayout.EAST, friday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText5, 185, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeFri, 22, SpringLayout.EAST, startTimeText5);
        	layout.putConstraint(SpringLayout.NORTH, startTimeFri, 181, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText5, 22, SpringLayout.EAST, startTimeFri);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText5, 185, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeFri, 22, SpringLayout.EAST, endTimeText5);
        	layout.putConstraint(SpringLayout.NORTH, endTimeFri, 181, SpringLayout.NORTH, timeSlots);
        	
        	//saturday
        	layout.putConstraint(SpringLayout.WEST, saturday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, saturday, 225, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText6, 20, SpringLayout.EAST, saturday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText6, 225, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeSat, 22, SpringLayout.EAST, startTimeText6);
        	layout.putConstraint(SpringLayout.NORTH, startTimeSat, 221, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText6, 22, SpringLayout.EAST, startTimeSat);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText6, 225, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeSat, 22, SpringLayout.EAST, endTimeText6);
        	layout.putConstraint(SpringLayout.NORTH, endTimeSat, 221, SpringLayout.NORTH, timeSlots);
        	
        	//sunday
        	layout.putConstraint(SpringLayout.WEST, sunday , 25, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, sunday, 265, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeText7, 32, SpringLayout.EAST, sunday);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText7, 265, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, startTimeSun, 22, SpringLayout.EAST, startTimeText7);
        	layout.putConstraint(SpringLayout.NORTH, startTimeSun, 261, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeText7, 22, SpringLayout.EAST, startTimeSun);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText7, 265, SpringLayout.NORTH, timeSlots);
        	layout.putConstraint(SpringLayout.WEST, endTimeSun, 22, SpringLayout.EAST, endTimeText7);
        	layout.putConstraint(SpringLayout.NORTH, endTimeSun, 261, SpringLayout.NORTH, timeSlots);
        	
        	layout.putConstraint(SpringLayout.WEST,createSchedule , 350, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, createSchedule, 305, SpringLayout.NORTH, timeSlots);
        	
        	JFrame f = new JFrame("Create Schedule");
         	f.getContentPane().add(p);
         	f.pack();
         	f.setSize(600, 450);
         	f.setVisible(true);
         	
         	//action listener for creating schedule
            createSchedule.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                
                
            	String room= comboRoom.getSelectedItem().toString();
            	String season= comboSeason.getSelectedItem().toString();
            	int mon_s = (Integer) startTimeMon.getSelectedItem();
            	int mon_e = (Integer) endTimeMon.getSelectedItem();
            	int tue_s = (Integer) startTimeTues.getSelectedItem();
            	int tue_e = (Integer) endTimeTues.getSelectedItem();
            	int wed_s = (Integer) startTimeWed.getSelectedItem();
            	int wed_e = (Integer) endTimeWed.getSelectedItem();
            	int thu_s = (Integer) startTimeThurs.getSelectedItem();
            	int thu_e = (Integer) endTimeThurs.getSelectedItem();
            	int fri_s = (Integer) startTimeFri.getSelectedItem();
            	int fri_e = (Integer) endTimeFri.getSelectedItem();
            	int sat_s = (Integer) startTimeSat.getSelectedItem();
            	int sat_e = (Integer) endTimeSat.getSelectedItem();
            	int sun_s = (Integer) startTimeSun.getSelectedItem();
            	int sun_e = (Integer) endTimeSun.getSelectedItem();
            	
            	
            	//Arrays.toString(arrayMon) to turn into a string
            	int [] arrayMon = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=mon_s && i<=mon_e && (mon_s!=mon_e))
            			arrayMon[i]=1;
            		else
            			arrayMon[i]=0;
            	}
            	
            	int [] arrayTue = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=tue_s && i<=tue_e && (tue_s!=tue_e))
            			arrayTue[i]=1;
            		else
            			arrayTue[i]=0;
            	}
            	
            	int [] arrayWed = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=wed_s && i<=wed_e && (wed_s!=wed_e))
            			arrayWed[i]=1;
            		else
            			arrayWed[i]=0;
            	}
            	
            	int [] arrayThu = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=thu_s && i<=thu_e && (thu_s!=thu_e))
            			arrayThu[i]=1;
            		else
            			arrayThu[i]=0;
            	}
            	
            	int [] arrayFri = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=fri_s && i<=fri_e && (fri_s!=fri_e))
            			arrayFri[i]=1;
            		else
            			arrayFri[i]=0;
            	}
            	
            	int [] arraySat = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=sat_s && i<=sat_e && (sat_s!=sat_e))
            			arraySat[i]=1;
            		else
            			arraySat[i]=0;
            	}
            	
            	int [] arraySun = new int[24];
            	for(int i=0; i<24; i++){
            		if(i>=sun_s && i<=sun_e && (sun_s!=sun_e))
            			arraySun[i]=1;
            		else
            			arraySun[i]=0;
            	}
            	Schedule newSched = new Schedule(room,season,arrayMon,arrayTue,arrayWed,
            			arrayThu,arrayFri,arraySat,arraySun);
            	
            	newSched.Create();
            	
            	
            	
                //Displaying message and clearing text fields
                JOptionPane.showMessageDialog(f.getComponent(0),"The "+season+" schedule has been created for the "+room) 
                ;

            }
        });
         	
        } 
}
       	 
       	 