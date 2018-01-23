
import java.awt.BorderLayout;
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import java.awt.Color;

public class loginFrame extends JFrame
{
    private static final int FRAME_WIDTH = 550;
    private static final int FRAME_HEIGHT = 350;
    private HashMap<String, String> inform; 
    private HashMap<String, String> informUser; 
    private JTextField nameFieldPrincipal;
    private JTextField passFieldPrincipal;
    private JTextField nameFieldUser;
    private JTextField passFieldUser;
    private JButton principalSelect;
    private JButton userSelect;
    private JButton loginButtonPrincipal;
    private JButton loginButtonUser;
    private JLabel welcomeLabel;
    private JLabel namePrincipal;
    private JLabel passwordPrincipal;
    private JLabel nameUser;
    private JLabel passwordUser;
    private JButton addEventButton;//after
    private JButton createScheduleButton;
    private JButton viewScheduleButton;
    private JButton logoutButton;//after
    private JButton requestAddEventButton;
    private JButton requestDeleteEventButton;
    private JPanel loginPanelSelection;
    private JPanel loginPanelPrincipal;
    private JPanel loginPanelUser;
    private JPanel welcomePanelPrincipal;
    private JPanel welcomePanelUser;
    private JPanel homePanel;
    private JPanel addSelection;
    private CardLayout cardLayout; 
    private JFrame testFrame;
 /**
  *  Constructor loginFrame
  *  Purpose: constructs the frame
  *
  *  @param Not used
  *  @return Nothing
  */
    public loginFrame()
    {
        createComponents();
        super.setTitle("Login Homepage");
        super.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

/**
  *  Method createComponents 
  *  Purpose: create components to be used
  *
  *  @param Not used
  *  @return Nothing
  */
    private void createComponents()
    {
        homePanel = new JPanel(new CardLayout());
        createHashMap();
        createHashMapUser();
        loginPanelSelection = this.createLoginPanel();
        loginPanelPrincipal = this.createLoginPanelPrincipal();
		    loginPanelUser = this.createLoginPanelUser();
        welcomePanelPrincipal = this.createWelcomePanelPrincipal();
        welcomePanelUser = this.createWelcomePanelUser();
        homePanel.add(this.loginPanelSelection, "Login Panel for Selection");
        homePanel.add(this.loginPanelPrincipal, "Login Panel for Principal");
        homePanel.add(this.loginPanelUser, "Login Panel for User");
        homePanel.add(this.welcomePanelPrincipal, "Welcome Panel for Principal");
        homePanel.add(this.welcomePanelUser, "Welcome Panel for User");
        this.cardLayout = (CardLayout) this.homePanel.getLayout();
        this.cardLayout.show(this.homePanel, "Login Panel for Selection");
        super.add(homePanel);
    }

/**
  *  Method createLoginPanel 
  *  Purpose: create login panel and components are added to it
  *
  *  @param Not used
  *  @return panel
  */
    private JPanel createLoginPanel()
    {
        JPanel panel = new JPanel(new GridLayout(2,1));
        this.principalSelect = new JButton("Principal Login");
        this.userSelect = new JButton("User Login");
        principalSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {// this.cardLayout.show(homePanel, "Welcome Panel for Principal");
                cardLayout.show(homePanel, "Login Panel for Principal");
            }
        });
        userSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {// this.cardLayout.show(homePanel, "Welcome Panel for Principal");
                cardLayout.show(homePanel, "Login Panel for User");
            }
        });
        panel.add(principalSelect);
        panel.add(userSelect);
        panel.setBackground(Color.black);
        return panel;
    }

/**
  *  Method createLoginPanelPrincipal
  *  Purpose: create login panel for the principal and components are added to it
  *
  *  @param Not used
  *  @return panel
  */
    private JPanel createLoginPanelPrincipal()
    {
        JPanel panel = new JPanel(new GridLayout(3,2));
        namePrincipal = new JLabel("Username: ");
        passwordPrincipal = new JLabel("Password: ");
        this.loginButtonPrincipal = new JButton("Login");
        int FIELD_WIDTH = 20;
        nameFieldPrincipal = new JTextField(FIELD_WIDTH);
        passFieldPrincipal = new JTextField(FIELD_WIDTH);
        loginButtonPrincipal.addActionListener(new ActionListener()
        {
            private int numAttempts = 3;
            public void actionPerformed(ActionEvent event)
            {
        		    boolean logged = false;
        		    String nameInput = nameFieldPrincipal.getText().toLowerCase();
        		    String passwordInput = passFieldPrincipal.getText();
        		    for(Map.Entry<String, String> a : inform.entrySet())
        		    {
                    if(nameInput.equals(a.getKey().toLowerCase()))
                    {
                        if (passwordInput.equals(a.getValue()))
                        {
                            System.out.println("Login Successful!");
                            cardLayout.show(homePanel, "Welcome Panel for Principal");
                            logged = true;
                        }
                    }
                }
                if(!logged)
                {
                    numAttempts -= 1;
                    if(numAttempts >= 1)
                    {
                        String val = Integer.toString(numAttempts);
                        String message = String.format("Invalid username/password. \n" + val + " Attempt(s) remaining");
                        nameFieldPrincipal.setText("");
                        passFieldPrincipal.setText("");
                        JOptionPane.showMessageDialog(null, message); 
                    }
                    else if(numAttempts == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Number of login attemtps exceeded. Terminating..."); 
                        System.exit(1); 
                    }
                }
            }
        });
        panel.add(namePrincipal);
        panel.add(nameFieldPrincipal);
        panel.add(passwordPrincipal);
        panel.add(passFieldPrincipal);
        panel.add(loginButtonPrincipal);
        panel.setBackground(Color.lightGray);
        return panel;
    }

/**
  *  Method createLoginPanelUser
  *  Purpose: create login panel for the user and components are added to it
  *
  *  @param Not used
  *  @return panel
  */
    private JPanel createLoginPanelUser()
    {
    	JPanel panel = new JPanel(new GridLayout(3,2));
    	nameUser = new JLabel("Username: ");
    	passwordUser = new JLabel("Password: ");
    	this.loginButtonUser = new JButton("Login");
    	final int FIELD_WIDTH = 20;
    	nameFieldUser = new JTextField(FIELD_WIDTH);
    	passFieldUser = new JTextField(FIELD_WIDTH);
    	loginButtonUser.addActionListener(new ActionListener()
      {
        	private int numAttempts = 3;
        	public void actionPerformed(ActionEvent event)
        	{
        		  boolean logged = false;
        		  String nameInput = nameFieldUser.getText().toLowerCase();
        		  String passwordInput = passFieldUser.getText();
        		  for(Map.Entry<String, String> a : informUser.entrySet())
        		  {
        		      if(nameInput.equals(a.getKey().toLowerCase()))
                  {
                      if (passwordInput.equals(a.getValue()))
                      {
                          System.out.println("Login Successful!");
                          cardLayout.show(homePanel, "Welcome Panel for User");
                          logged = true;
                      }
                  }
        		  }
        		  if(!logged)
              {
                  numAttempts -= 1;
                  if(numAttempts >= 1)
                  {
                        String val = Integer.toString(numAttempts);
                        String message = String.format("Invalid username/password. \n" + val + " Attempt(s) remaining");
                        nameFieldUser.setText("");
                        passFieldUser.setText("");
                        JOptionPane.showMessageDialog(null, message); 
                    }
                    else if(numAttempts == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Number of login attemtps exceeded. Terminating..."); 
                        System.exit(1); 
                    }
                }
        	}
        });
        panel.add(nameUser);
  		  panel.add(nameFieldUser);
  		  panel.add(passwordUser);
  		  panel.add(passFieldUser);
  		  panel.add(loginButtonUser);
        panel.setBackground(Color.lightGray);
  		  return panel;
    }

/**
  *  Method createWelcomePanelPrincipal 
  *  Purpose: creates the welcome login panel for the principal and components are added to it
  *
  *  @param Not used
  *  @return panel
  */
    private JPanel createWelcomePanelPrincipal()
    {
        JPanel panel = new JPanel(new GridLayout(7,1));
        welcomeLabel = new JLabel("Welcome!");
        addEventButton = new JButton("Add Event");
        createScheduleButton = new JButton("Create Schedule");
        viewScheduleButton = new JButton("View Schedule");
        panel.add(welcomeLabel);
        panel.add(addEventButton);
        panel.add(createScheduleButton);
        panel.add(viewScheduleButton);
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	cardLayout.show(homePanel, "Login Panel for Selection");
            }
        });
        createScheduleButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	CreateSchedule on = new CreateSchedule(testFrame);
            }
        });
        
        viewScheduleButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	ViewSchedule on = new ViewSchedule(testFrame);
            }
        });
        
        addEventButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                AddByRequest on = new AddByRequest(testFrame);
            }
        });
        panel.add(logoutButton);
        panel.setBackground(Color.lightGray);
        return panel;
    }

/**
  *  Method createWelcomePanelUser
  *  Purpose: creates the welcome login panel for the user and components are added to it
  *
  *  @param Not used
  *  @return panel
  */
    private JPanel createWelcomePanelUser()
    {
        JPanel panel = new JPanel(new GridLayout(6,1));
        welcomeLabel = new JLabel("Welcome!");
        requestAddEventButton = new JButton("Request Event Add");
        viewScheduleButton = new JButton("View Schedule");
        panel.add(welcomeLabel);
        panel.add(requestAddEventButton);
        panel.add(viewScheduleButton);
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	cardLayout.show(homePanel, "Login Panel for Selection");
            }
        });
        
        viewScheduleButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	ViewSchedule on = new ViewSchedule(testFrame);
            }
        });
        
        requestAddEventButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Request on = new Request(testFrame);
            }
        });
        
        panel.add(logoutButton);
        panel.setBackground(Color.lightGray);
        return panel;
    }

/**
  *  Method createHashMap
  *  Purpose: gets information from the file text
  *
  *  @param Not used
  *  @return Nothing
  */
    private void createHashMap()
    {
        this.inform = new HashMap<String, String>();
        try
        {
            File file = new File("PrincipalPass.txt");
            Scanner fileScan = new Scanner(file);
            while(fileScan.hasNextLine())
            {
                String line = fileScan.nextLine();
                String[] splitted = line.split(" ");
                this.inform.put(splitted[0], splitted[1]);
                System.out.println(splitted[0] + " " + splitted[1]);
            }
            fileScan.close();
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error: no users.txt file found. No users/passwords available to read."); 
        }
    }

/**
  *  Method createHashMapUser
  *  Purpose: gets information from the file text
  *
  *  @param Not used
  *  @return Nothing
  */
    private void createHashMapUser()
    {
        this.informUser = new HashMap<String, String>();
        try
        {
            File file = new File("User.txt");
            Scanner fileScan = new Scanner(file);
            while(fileScan.hasNextLine())
            {
                String line = fileScan.nextLine();
                String[] splitted = line.split(" ");
                this.informUser.put(splitted[0], splitted[1]);
                System.out.println(splitted[0] + " " + splitted[1]);
            }
            fileScan.close();
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error: no users.txt file found. No users/passwords available to read."); 
        }
    }
    public static void main(String[] args)
    { 
        JFrame testFrame = new loginFrame(); 
        testFrame.getContentPane().setBackground(Color.RED);
        testFrame.setVisible(true);
    } 
}