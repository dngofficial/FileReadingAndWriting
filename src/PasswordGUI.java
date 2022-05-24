import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

// this class implements ActionListener interface, which allows for interactivity with JButtons
public class PasswordGUI implements ActionListener {

    private JLabel feedback;
    private JLabel username;
    private JLabel password;
    private JLabel logIn;
    private final PersonSaver personSaver;
    private JButton submit;
    private JButton newAccount;
    private JFrame frame;


    public PasswordGUI() {
        feedback = new JLabel();
        username = new JLabel();
        password = new JLabel();
        logIn = new JLabel();
        personSaver = new PersonSaver();
        frame = new JFrame("PasswordSIM by Devan");

        setupGui();

    }


    // private helper method, called by constructor
    // to set up the GUI and display it
    private void setupGui() {
        //Creating a Frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ends program when you hit the X

        JLabel welcomeLabel = new JLabel("PasswordSIM©");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 70));
        welcomeLabel.setForeground(Color.darkGray);


        logIn = new JLabel("Enter Username and password");
        logIn.setFont(new Font("Arial", Font.BOLD, 30));
        logIn.setBackground(Color.lightGray);


        //top panel
        JPanel topPanel = new JPanel((new GridBagLayout()));


        GridBagConstraints topC = new GridBagConstraints();
        topC.gridx = 0;
        topC.gridy = 1;
        topPanel.add(welcomeLabel, topC);
        topC.gridx = 0;
        topC.gridy = 2;
        topPanel.add(logIn, topC);

        //middle panel with text field username
        JPanel entryPanelUser = new JPanel(); // the panel is not visible in output
        username = new JLabel("Username: ");
        JTextField usernameEntryField = new JTextField(20); // accepts up to 20 characters
        entryPanelUser.add(username);
        entryPanelUser.add(usernameEntryField);

        //middle panel with text field password
        JPanel entryPanelPassword = new JPanel();
        password = new JLabel("Password: ");
        JTextField passwordEntryField = new JTextField(20); // accepts up to 20 characters
        entryPanelPassword.add(password);
        entryPanelPassword.add(passwordEntryField);

        //middle panel

        feedback = new JLabel("Feedback");


        //bottom panel
        JPanel submitPanel = new JPanel();
        submit = new JButton("Log In");
        newAccount = new JButton("Create New Account");
        submitPanel.add(submit);
        submitPanel.add(newAccount);

        JPanel p = new JPanel((new GridBagLayout()));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        p.add(entryPanelUser, c);
        c.gridx = 0;
        c.gridy = 2;
        p.add(entryPanelPassword, c);
        c.gridx = 0;
        c.gridy = 3;
        p.add(feedback, c);


        //Adding Components to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(p, BorderLayout.CENTER);
        frame.add(submitPanel, BorderLayout.SOUTH);

//         PART 2 -- SET UP EVENT HANDLING
//        setting up buttons to use ActionListener interface and actionPerformed method
        submit.addActionListener(this);
        newAccount.addActionListener(this);


        // showing the frame
        frame.pack();
        frame.setVisible(true);


    }

    public void changeToCreateAccount() {

        feedback.setText("feedback here");
        username.setText("Create username (max 20 characters): ");
        password.setText("Create password (max 20 characters): ");
        logIn.setText("Create a new account");
        submit.setText("Create Account");
        newAccount.setText("Back");
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);

    }

    public void changeToAccountEditor() {

        feedback.setText("feedback here");
        username.setText("Change current username (max 20 characters): ");
        password.setText("Create current password (max 20 characters): ");
        logIn.setText("Change an account's info");
        submit.setText("Change Account");
        newAccount.setText("Log Out");
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);

    }


    public void changeToLogIn() {

        feedback.setText("Feedback");
        username.setText("Username: ");
        password.setText("Password: ");
        logIn.setText("Create a new account");
        submit.setText("Log In");
        newAccount.setText("Create New Account");
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());  // cast source to JButton
        String text = button.getText();

        if (text.equals("Create New Account"))
        {

            changeToCreateAccount();

        }
        else if(text.equals("Log In"))
        {
            changeToAccountEditor();
        }

        else if (text.equals("Back") || text.equals("Log Out"))
        {
            changeToLogIn();

        }
    }
//
//    private void updateDisplayPanel(String text) {
//
//
//        WeatherNetworking api = new WeatherNetworking();
//        currentWeather = api.parseCurrent(api.makeAPICallForForecast(text));
//        double currentF = currentWeather.getCurrentF();
//        double currentC = currentWeather.getCurrentC();
//        String filePath = currentWeather.getFilePath();
//        String condition1 = currentWeather.getCondition();
//
//
//        System.out.println(checkbox.isSelected());
//
//
//        if (checkbox.isSelected())
//        {
//            temperature.setText("Temperature: " + currentC + " C°");
//        }
//        else
//        {
//            temperature.setText("Temperature: " + currentF + " F°");
//        }
//
//        condition.setText("Condition: " + condition1);
//
//        try {
//
//            URL imageURL = new URL("https:" + filePath);
//            BufferedImage image = ImageIO.read(imageURL);
//            ImageIcon icon = new ImageIcon(image);
//            pictureLabel.setIcon(icon);
//
//        }
//        catch (IOException e)
//        {
//            System.out.println("image no works");
//        }
//
//
//    }
//
//
}
