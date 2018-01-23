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
 
//create class
class DisplayTest 
{
	//define variables
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        //create object of JLabel with alignment
        JLabel l = new JLabel("", JLabel.CENTER);
        //define variable
        String day = "";
        //declaration
        JDialog d;
        //create object of JButton
        JButton[] button = new JButton[49];
 
        public DisplayTest(JFrame parent)//create constructor 
        {
        	//create object
                d = new JDialog();
                //set modal true
                d.setModal(true);
                //define string
                String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
                //create JPanel object and set layout
                JPanel p1 = new JPanel(new GridLayout(7, 7));
                //set size
                p1.setPreferredSize(new Dimension(430, 120));
                //for loop condition
                for (int x = 0; x < button.length; x++) 
                {		
                	//define variable
                        final int selection = x;
                        //create object of JButton
                        button[x] = new JButton();
                        //set focus painted false
                        button[x].setFocusPainted(false);
                        //set background colour
                        button[x].setBackground(Color.white);
                        //if loop condition
                        if (x > 6)
                        //add action listener
                        button[x].addActionListener(new ActionListener() 
                        {
                                 public void actionPerformed(ActionEvent ae) 
                                 {
                                       day = button[selection].getActionCommand();
                                       //call dispose() method
                                       d.dispose();
                                 }
                        });
                        if (x < 7)//if loop condition 
                        {
                                button[x].setText(header[x]);
                                //set fore ground colour
                                button[x].setForeground(Color.red);
                        }
                        p1.add(button[x]);//add button
                }
                //create JPanel object with grid layout
                JPanel p2 = new JPanel(new GridLayout(1, 3));
                
                //create object of button for previous month
                JButton previous = new JButton("<< Previous");
                //add action command
                previous.addActionListener(new ActionListener() 
                {
                        public void actionPerformed(ActionEvent ae) 
                        {
                            //decrement month by 1
                            month--;
                            //call method
                            displayDate();
                        }
                });
                p2.add(previous);//add button
                p2.add(l);//add label
                //create object of button for next month
                JButton next = new JButton("Next >>");
                //add action command
                next.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent ae) 
                        {
                             //increment month by 1
                             month++;
                             //call method
                            displayDate();
                        }
                });
                p2.add(next);// add next button
                //set border alignment
                d.add(p1, BorderLayout.CENTER);
                d.add(p2, BorderLayout.SOUTH);
                d.pack();
                //set location
                d.setLocationRelativeTo(parent);
                //call method
                displayDate();
                //set visible true
                d.setVisible(true);
        }
 
        public void displayDate() 
        {
        	for (int x = 7; x < button.length; x++)//for loop
        	button[x].setText("");//set text
      	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");	
                //create object of SimpleDateFormat 
                java.util.Calendar cal = java.util.Calendar.getInstance();			
                //create object of java.util.Calendar 
        	cal.set(year, month, 1); //set year, month and date
         	//define variables
        	int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        	int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        	//condition
        	for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
        	//set text
        	button[x].setText("" + day);
        	l.setText(sdf.format(cal.getTime()));
        	//set title
        	d.setTitle("Event Requester");
        }
 
        public String setPickedDate() 
        {
        	//if condition
        	if (day.equals(""))
        		return day;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(year, month, Integer.parseInt(day));
            return sdf.format(cal.getTime());
        }
}
 
//class for requesting event(accessed by staff/students)
class Request
{
        public Request(JFrame parent)//create constructor 
        
        {	
        	

        	SpringLayout layout = new SpringLayout();
        	
        	//create objects of JLabel and set labels
        	JLabel label = new JLabel("Event Date:");
        	JLabel eventLabel = new JLabel("Event Name:");
        	JLabel roomLabel = new JLabel("Room:");
        	JLabel lengthLabel = new JLabel("Event Length (minutes):");
        	JLabel timeLabel = new JLabel("Start Time:");
        	
        	//create object of JTextField and declare it final
        	final JTextField text = new JTextField(20);
        	final JTextField event = new JTextField(20);
        	final JTextField room = new JTextField(20);
        	final JTextField  length= new JTextField(20);
        	
        	//Time selection
        	JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        	JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        	timeSpinner.setEditor(timeEditor);
        	timeSpinner.setValue(new Date());
        	
        	
        	//create object of JButton
        	JButton b = new JButton("Select Date");
        	JButton request = new JButton("Request Event");
        	request.setBackground(Color.RED);
        	request.setOpaque(true);
        	
        	//create objects of JPanel
        	JPanel p = new JPanel(new SpringLayout());
        	p.setLayout(layout);
        	p.add(label);
        	p.add(text);
        	p.add(b);
        	p.add(eventLabel);
        	p.add(event);
        	p.add(roomLabel);
        	p.add(room);
        	p.add(lengthLabel);
        	p.add(length);
        	p.add(timeLabel);
        	p.add(timeSpinner);
        	p.add(request);
        	
        	//postioning the objects into rows
        	layout.putConstraint(SpringLayout.WEST,label , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, text, 25, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, b, 22, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, text, 80, SpringLayout.EAST, label);
        	layout.putConstraint(SpringLayout.WEST, b, 20, SpringLayout.EAST, text);
            	
        	layout.putConstraint(SpringLayout.WEST,eventLabel , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, eventLabel, 50, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, event, 50, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, event, 74, SpringLayout.EAST, eventLabel);
            
        	layout.putConstraint(SpringLayout.WEST,roomLabel , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, roomLabel, 75, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, room, 75, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, room, 117, SpringLayout.EAST, roomLabel);
            
        	layout.putConstraint(SpringLayout.WEST,lengthLabel , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, lengthLabel, 100, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, length, 100, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, length, 9, SpringLayout.EAST, lengthLabel);
            
        	layout.putConstraint(SpringLayout.WEST,timeLabel , 10, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, timeLabel, 125, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.NORTH, timeSpinner, 125, SpringLayout.NORTH, p);
        	layout.putConstraint(SpringLayout.WEST, timeSpinner, 84, SpringLayout.EAST, timeLabel);
            
        	layout.putConstraint(SpringLayout.WEST,request , 171, SpringLayout.WEST, p);
        	layout.putConstraint(SpringLayout.NORTH, request, 150, SpringLayout.NORTH, p);
        	
        	
        	//create object of JFrame and declare it final
            JFrame f = new JFrame("Request Event");
        	f.getContentPane().add(p);
        	f.pack();
        	f.setSize(600, 300);
        	f.setVisible(true);
        	
        	//action listener for calendar
        	b.addActionListener(new ActionListener() 
        	{
        		public void actionPerformed(ActionEvent ae) 
        		{
        			//set text i.e. date
        			text.setText(new DisplayTest(f).setPickedDate());
        		}
            });
        	
            //action listener for requesting event
            request.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
            	
            	
            	String name = event.getText();
            	String roomName = room.getText();
            	String eventLength1 = length.getText();
            	int eventLength2 = Integer.parseInt(eventLength1);
            	
            	//getting hour and minute into int form
                String currentTime = timeEditor.getFormat().format(timeSpinner.getValue());
                String hour = currentTime.substring(0, 2);
                String minute = currentTime.substring(3,5);
                int hr = Integer.parseInt(hour);
                int min = Integer.parseInt(minute);
            	
            	//getting day,month and year into int form
            	String currentDay = text.getText();
            	String selectDay = currentDay.substring(0, 2);
            	String selectMonth = currentDay.substring(3, 5);
            	String selectYear = currentDay.substring(6,10);
            	int day1 = Integer.parseInt(selectDay);
                int month1 = Integer.parseInt(selectMonth);
                int year1 = Integer.parseInt(selectYear);
                //creating calendar object
                Calendar date = Calendar.getInstance();
                date.set(year1, month1, day1, hr, min);
                
                
                
                //Displaying message and clearing text fields
                JOptionPane.showMessageDialog(f.getComponent(0), "Your requested event has been sent to the principal for further review.");
                text.setText("");
                event.setText("");
                room.setText("");
                length.setText("");
                
                //creating event
                Event event = new Event(name, roomName, date, eventLength2);
                
                //calling method to add event to RequestedEvent.txt
                event.RequestEvent();

            }
        });
            
        }
}

class AddManually 
{
    public AddManually(JFrame parent)//create constructor 
    {   
        SpringLayout layout = new SpringLayout();   
        //create objects of JLabel and set labels
        JLabel label = new JLabel("Event Date:");
        JLabel eventLabel = new JLabel("Event Name:");
        JLabel roomLabel = new JLabel("Room:");
        JLabel lengthLabel = new JLabel("Event Length (minutes):");
        JLabel timeLabel = new JLabel("Start Time:");
        final JTextField text = new JTextField(20);
        final JTextField event = new JTextField(20);
        final JTextField room = new JTextField(20);
        final JTextField  length= new JTextField(20);
        JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        JButton b = new JButton("Select Date");
        JButton request = new JButton("Request Event");
        request.setBackground(Color.RED);
        request.setOpaque(true);//create objects of JPanel
        JPanel p = new JPanel(new SpringLayout());
        p.setLayout(layout);
        p.add(label);
        p.add(text);
        p.add(b);
        p.add(eventLabel);
        p.add(event);
        p.add(roomLabel);
        p.add(room);
        p.add(lengthLabel);
        p.add(length);
        p.add(timeLabel);
        p.add(timeSpinner);
        p.add(request);
        //postioning the objects into rows
        layout.putConstraint(SpringLayout.WEST,label , 10, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, text, 25, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, b, 22, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, text, 80, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.WEST, b, 20, SpringLayout.EAST, text);    
        layout.putConstraint(SpringLayout.WEST,eventLabel , 10, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, eventLabel, 50, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, event, 50, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, event, 74, SpringLayout.EAST, eventLabel);
        layout.putConstraint(SpringLayout.WEST,roomLabel , 10, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, roomLabel, 75, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, room, 75, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, room, 117, SpringLayout.EAST, roomLabel);
        layout.putConstraint(SpringLayout.WEST,lengthLabel , 10, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, lengthLabel, 100, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, length, 100, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, length, 9, SpringLayout.EAST, lengthLabel);
        layout.putConstraint(SpringLayout.WEST,timeLabel , 10, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, timeLabel, 125, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.NORTH, timeSpinner, 125, SpringLayout.NORTH, p);
        layout.putConstraint(SpringLayout.WEST, timeSpinner, 84, SpringLayout.EAST, timeLabel);
        layout.putConstraint(SpringLayout.WEST,request , 171, SpringLayout.WEST, p);
        layout.putConstraint(SpringLayout.NORTH, request, 150, SpringLayout.NORTH, p);//create object of JFrame and declare it final
        JFrame f = new JFrame("Add Event");
        f.getContentPane().add(p);
        f.pack();
        f.setSize(600, 300);
        f.setVisible(true);
            //action listener for calendar
        b.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                //set text i.e. date
                text.setText(new DisplayTest(f).setPickedDate());
            }
        });//action listener for requesting event
        request.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                String name = event.getText();
                String roomName = room.getText();
                String eventLength1 = length.getText();
                int eventLength2 = Integer.parseInt(eventLength1);
                //getting hour and minute into int form
                String currentTime = timeEditor.getFormat().format(timeSpinner.getValue());
                String hour = currentTime.substring(0, 2);
                String minute = currentTime.substring(3,5);
                int hr = Integer.parseInt(hour);
                int min = Integer.parseInt(minute);
                //getting day,month and year into int form
                String currentDay = text.getText();
                String selectDay = currentDay.substring(0, 2);
                String selectMonth = currentDay.substring(3, 5);
                String selectYear = currentDay.substring(6,10);
                int day1 = Integer.parseInt(selectDay);
                int month1 = Integer.parseInt(selectMonth);
                int year1 = Integer.parseInt(selectYear);
                //creating calendar object
                Calendar date = Calendar.getInstance();
                date.set(year1, month1, day1, hr, min);
                //Displaying message and clearing text fields
                JOptionPane.showMessageDialog(f.getComponent(0), "Your Event has been added.");
                text.setText("");
                event.setText("");
                room.setText("");
                length.setText("");
                //creating event
                Event event = new Event(name, roomName, date, eventLength2);
                //calling method to add event to RequestedEvent.txt
                event.addManualEvent();
            }
        });  
    }
}