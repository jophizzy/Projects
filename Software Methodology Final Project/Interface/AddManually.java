//import statements
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
class AddManually
{
        public AddManually(JFrame parent)//create constructor 
        {	

        	SpringLayout layout = new SpringLayout();
        	
        	//create objects of JLabel and set labels
        	JLabel eventName = new JLabel("Event Name:");
        	JLabel eventSeasons = new JLabel("Event Seasons:");
        	JLabel eventRoom = new JLabel("Event Room:");
        	JLabel eventSlots = new JLabel("Slots Requested:");
        	JLabel eventPriority = new JLabel("<html><u>Timeslot Priority</u></html>");
        	JLabel priority1 = new JLabel("First:");
        	JLabel priority2 = new JLabel("Second:");
        	JLabel priority3 = new JLabel("Third:");
        	JLabel priority4 = new JLabel("Fourth:");
        	JLabel priority5 = new JLabel("Fifth:");
        	
        	//for priority slots
        	JLabel day1 = new JLabel("Select Day:");
        	JLabel startTimeText1 = new JLabel("Start Time (hour):");
        	JLabel endTimeText1 = new JLabel("End Time (hour):");
        	
        	JLabel day2 = new JLabel("Select Day:");
        	JLabel day3 = new JLabel("Select Day:");
        	JLabel day4 = new JLabel("Select Day:");
        	JLabel day5 = new JLabel("Select Day:");
        	
        	JLabel startTimeText2 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText3 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText4 =  new JLabel("Start Time (hour):");
        	JLabel startTimeText5 =  new JLabel("Start Time (hour):");
        	
        	JLabel endTimeText2 = new JLabel("End Time (hour):");
        	JLabel endTimeText3 = new JLabel("End Time (hour):");
        	JLabel endTimeText4 = new JLabel("End Time (hour):");
        	JLabel endTimeText5 = new JLabel("End Time (hour):");
        	
        	
        	
        	//create object of JTextField and declare it final
        	final JTextField name = new JTextField(20);
        	
        	//create checkbox objects
        	 JCheckBox winter = new JCheckBox("Winter");
        	 winter.setMnemonic(KeyEvent.VK_C); 
        	 winter.setSelected(false);
        	
        	 JCheckBox spring = new JCheckBox("Spring");
        	 spring.setMnemonic(KeyEvent.VK_C); 
        	 spring.setSelected(false);
        	
        	 JCheckBox summer = new JCheckBox("Summer");
        	 summer.setMnemonic(KeyEvent.VK_C); 
        	 summer.setSelected(false);
        	
        	 JCheckBox fall = new JCheckBox("Fall");
        	 fall.setMnemonic(KeyEvent.VK_C); 
        	 fall.setSelected(false);
        	 
        	//create combo box objects
        	 JComboBox<String> comboRoom = new JComboBox<String>();
        	 comboRoom.addItem("Gymnasium");
        	 comboRoom.addItem("Auditorium");
        	 comboRoom.addItem("Cafeteria");
        	 comboRoom.addItem("Library");
        	 comboRoom.addItem("Lecture Room");
        	 
        	 JComboBox<Integer> comboSlots = new JComboBox<Integer>();
        	 comboSlots.addItem(1);
        	 comboSlots.addItem(2);
        	 comboSlots.addItem(3);
        	 comboSlots.addItem(4);
        	 comboSlots.addItem(5);
        	 
        	 JComboBox<String> comboDay1 = new JComboBox<String>();
        	 comboDay1.addItem("Monday");
        	 comboDay1.addItem("Tuesday");
        	 comboDay1.addItem("Wednesday");
        	 comboDay1.addItem("Thursday");
        	 comboDay1.addItem("Friday");
        	 comboDay1.addItem("Saturday");
        	 comboDay1.addItem("Sunday");
        	 
        	 JComboBox<String> comboDay2 = new JComboBox<String>();
        	 comboDay2.addItem("Monday");
        	 comboDay2.addItem("Tuesday");
        	 comboDay2.addItem("Wednesday");
        	 comboDay2.addItem("Thursday");
        	 comboDay2.addItem("Friday");
        	 comboDay2.addItem("Saturday");
        	 comboDay2.addItem("Sunday");
        	 
        	 JComboBox<String> comboDay3 = new JComboBox<String>();
        	 comboDay3.addItem("Monday");
        	 comboDay3.addItem("Tuesday");
        	 comboDay3.addItem("Wednesday");
        	 comboDay3.addItem("Thursday");
        	 comboDay3.addItem("Friday");
        	 comboDay3.addItem("Saturday");
        	 comboDay3.addItem("Sunday");
        	 
        	 JComboBox<String> comboDay4 = new JComboBox<String>();
        	 comboDay4.addItem("Monday");
        	 comboDay4.addItem("Tuesday");
        	 comboDay4.addItem("Wednesday");
        	 comboDay4.addItem("Thursday");
        	 comboDay4.addItem("Friday");
        	 comboDay4.addItem("Saturday");
        	 comboDay4.addItem("Sunday");
        	 
        	 JComboBox<String> comboDay5 = new JComboBox<String>();
        	 comboDay5.addItem("Monday");
        	 comboDay5.addItem("Tuesday");
        	 comboDay5.addItem("Wednesday");
        	 comboDay5.addItem("Thursday");
        	 comboDay5.addItem("Friday");
        	 comboDay5.addItem("Saturday");
        	 comboDay5.addItem("Sunday");
        	 
        	 JComboBox<Integer> startTime1 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 startTime1.addItem(i);
        	 }
        	 
        	 JComboBox<Integer> startTime2 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 startTime2.addItem(i);
        	 }
        	 
        	 JComboBox<Integer> startTime3 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 startTime3.addItem(i);
        	 }
        	 
        	 JComboBox<Integer> startTime4 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 startTime4.addItem(i);
        	 }
        	 
        	 JComboBox<Integer> startTime5 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 startTime5.addItem(i);
        	 }

        	 
        	 JComboBox<Integer> endTime1 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 endTime1.addItem(i);
        	 }
        	 JComboBox<Integer> endTime2 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 endTime2.addItem(i);
        	 }
        	 JComboBox<Integer> endTime3 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 endTime3.addItem(i);
        	 }
        	 JComboBox<Integer> endTime4 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 endTime4.addItem(i);
        	 }
        	 JComboBox<Integer> endTime5 = new JComboBox<Integer>();
        	 for(int i=0; i<24; i++){
        		 endTime5.addItem(i);
        	 }
        	
        	//create object of JButton
        	JButton request = new JButton("Add Event");
        	request.setBackground(Color.RED);
        	request.setOpaque(true);
        	
        	//create object of JPanel
        	JPanel p = new JPanel(new SpringLayout());
        	p.setLayout(layout);
        	p.add(eventName);
        	p.add(eventSeasons);
        	p.add(eventRoom);
        	p.add(eventSlots);
        	p.add(eventPriority);
        	p.add(priority1);
        	p.add(priority2);
        	p.add(priority3);
        	p.add(priority4);
        	p.add(priority5);
        	p.add(day1);
        	p.add(startTimeText1);
        	p.add(endTimeText1);
        	p.add(day2);
        	p.add(startTimeText2);
        	p.add(endTimeText2);
        	p.add(day3);
        	p.add(startTimeText3);
        	p.add(endTimeText3);
        	p.add(day4);
        	p.add(startTimeText4);
        	p.add(endTimeText4);
        	p.add(day5);
        	p.add(startTimeText5);
        	p.add(endTimeText5);
        	p.add(name);
        	p.add(winter);
        	p.add(spring);
        	p.add(summer);
        	p.add(fall);
        	p.add(comboRoom);
        	p.add(comboSlots);
        	p.add(request);
        	p.add(comboDay1);
        	p.add(comboDay2);
        	p.add(comboDay3);
        	p.add(comboDay4);
        	p.add(comboDay5);
        	p.add(startTime1);
        	p.add(startTime2);
        	p.add(startTime3);
        	p.add(startTime4);
        	p.add(startTime5);
        	p.add(endTime1);
        	p.add(endTime2);
        	p.add(endTime3);
        	p.add(endTime4);
        	p.add(endTime5);
        	

        	//postioning the objects into rows
        	layout.putConstraint(SpringLayout.WEST,eventName , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventName, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, name, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, name, 22, SpringLayout.EAST, eventName);
        	
        	layout.putConstraint(SpringLayout.WEST,eventSeasons , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventSeasons, 62, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, winter, 60, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, winter, 22, SpringLayout.EAST, eventSeasons);
        	layout.putConstraint(SpringLayout.NORTH, spring, 60, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, spring, 22, SpringLayout.EAST, winter);
        	layout.putConstraint(SpringLayout.NORTH, summer, 60, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, summer, 22, SpringLayout.EAST, spring);
        	layout.putConstraint(SpringLayout.NORTH, fall, 60, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, fall, 22, SpringLayout.EAST, summer);
        	
        	layout.putConstraint(SpringLayout.WEST,eventRoom , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventRoom, 95, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, comboRoom, 91, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, comboRoom, 22, SpringLayout.EAST, eventRoom);
        	
        	layout.putConstraint(SpringLayout.WEST,eventSlots , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventSlots, 130, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, comboSlots, 126, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, comboSlots, 22, SpringLayout.EAST, eventSlots);
        	
        	layout.putConstraint(SpringLayout.WEST,eventPriority , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventPriority, 165, SpringLayout.NORTH, p);
        	
        	layout.putConstraint(SpringLayout.WEST,priority1 , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, priority1, 25, SpringLayout.NORTH, eventPriority);
        	layout.putConstraint(SpringLayout.NORTH, day1, 20, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, day1, 20, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, comboDay1, 16, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, comboDay1, 22, SpringLayout.EAST, day1);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText1, 20, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, startTimeText1, 22, SpringLayout.EAST, comboDay1);
        	layout.putConstraint(SpringLayout.NORTH, startTime1, 16, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, startTime1, 22, SpringLayout.EAST, startTimeText1);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText1, 20, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, endTimeText1, 22, SpringLayout.EAST, startTime1);
        	layout.putConstraint(SpringLayout.NORTH, endTime1, 16, SpringLayout.NORTH, priority1);
        	layout.putConstraint(SpringLayout.WEST, endTime1, 22, SpringLayout.EAST, endTimeText1);
        	
        	layout.putConstraint(SpringLayout.WEST,priority2 , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, priority2, 100, SpringLayout.NORTH, eventPriority);
        	layout.putConstraint(SpringLayout.NORTH, day2, 20, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, day2, 20, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, comboDay2, 16, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, comboDay2, 22, SpringLayout.EAST, day2);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText2, 20, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, startTimeText2, 22, SpringLayout.EAST, comboDay2);
        	layout.putConstraint(SpringLayout.NORTH, startTime2, 16, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, startTime2, 22, SpringLayout.EAST, startTimeText2);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText2, 20, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, endTimeText2, 22, SpringLayout.EAST, startTime2);
        	layout.putConstraint(SpringLayout.NORTH, endTime2, 16, SpringLayout.NORTH, priority2);
        	layout.putConstraint(SpringLayout.WEST, endTime2, 22, SpringLayout.EAST, endTimeText2);
        	
        	layout.putConstraint(SpringLayout.WEST,priority3 , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, priority3, 175, SpringLayout.NORTH, eventPriority);
        	layout.putConstraint(SpringLayout.NORTH, day3, 20, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, day3, 20, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, comboDay3, 16, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, comboDay3, 22, SpringLayout.EAST, day3);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText3, 20, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, startTimeText3, 22, SpringLayout.EAST, comboDay3);
        	layout.putConstraint(SpringLayout.NORTH, startTime3, 16, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, startTime3, 22, SpringLayout.EAST, startTimeText3);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText3, 20, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, endTimeText3, 22, SpringLayout.EAST, startTime3);
        	layout.putConstraint(SpringLayout.NORTH, endTime3, 16, SpringLayout.NORTH, priority3);
        	layout.putConstraint(SpringLayout.WEST, endTime3, 22, SpringLayout.EAST, endTimeText3);
        	
        	layout.putConstraint(SpringLayout.WEST,priority4 , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, priority4, 250, SpringLayout.NORTH, eventPriority);
        	layout.putConstraint(SpringLayout.NORTH, day4, 20, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, day4, 20, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, comboDay4, 16, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, comboDay4, 22, SpringLayout.EAST, day4);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText4, 20, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, startTimeText4, 22, SpringLayout.EAST, comboDay4);
        	layout.putConstraint(SpringLayout.NORTH, startTime4, 16, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, startTime4, 22, SpringLayout.EAST, startTimeText4);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText4, 20, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, endTimeText4, 22, SpringLayout.EAST, startTime4);
        	layout.putConstraint(SpringLayout.NORTH, endTime4, 16, SpringLayout.NORTH, priority4);
        	layout.putConstraint(SpringLayout.WEST, endTime4, 22, SpringLayout.EAST, endTimeText4);
        	
        	layout.putConstraint(SpringLayout.WEST,priority5 , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, priority5, 325, SpringLayout.NORTH, eventPriority);
        	layout.putConstraint(SpringLayout.NORTH, day5, 20, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, day5, 20, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, comboDay5, 16, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, comboDay5, 22, SpringLayout.EAST, day5);
        	layout.putConstraint(SpringLayout.NORTH, startTimeText5, 20, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, startTimeText5, 22, SpringLayout.EAST, comboDay5);
        	layout.putConstraint(SpringLayout.NORTH, startTime5, 16, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, startTime5, 22, SpringLayout.EAST, startTimeText5);
        	layout.putConstraint(SpringLayout.NORTH, endTimeText5, 20, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, endTimeText5, 22, SpringLayout.EAST, startTime5);
        	layout.putConstraint(SpringLayout.NORTH, endTime5, 16, SpringLayout.NORTH, priority5);
        	layout.putConstraint(SpringLayout.WEST, endTime5, 22, SpringLayout.EAST, endTimeText5);
        	
        	layout.putConstraint(SpringLayout.WEST,request , 517, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, request, 400, SpringLayout.NORTH, eventPriority);
        	
        	
        	//create object of JFrame and declare it final
            JFrame f = new JFrame("Add Event");
        	f.getContentPane().add(p);
        	f.pack();
        	f.setSize(690, 625);
        	f.setVisible(true);
        	

        	
            //action listener for requesting event
            request.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                
                
                
                //Displaying message and clearing text fields
                JOptionPane.showMessageDialog(f.getComponent(0), "Event has been added");

            }
        });
        	
        	
            
        }
}