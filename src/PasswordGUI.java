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
public class PasswordGUI {



    public PasswordGUI() {
        setupGui();
    }


    // private helper method, called by constructor
    // to set up the GUI and display it
    private void setupGui() {
        //Creating a Frame
        JFrame frame = new JFrame("PassWord");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ends program when you hit the X

        JLabel welcomeLabel = new JLabel("Password©");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        welcomeLabel.setForeground(Color.darkGray);

        JLabel nameLabel = new JLabel("Devan Ng");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 10));
        nameLabel.setBackground(Color.darkGray);

        //top panel
        JPanel topPanel = new JPanel(); // the panel is not visible in output
        topPanel.add(welcomeLabel);
        topPanel.add(nameLabel);

        //middle panel with text field username
        JPanel entryPanelUser = new JPanel(); // the panel is not visible in output
        JLabel username = new JLabel("Username: ");
        JTextField usernameEntryField = new JTextField(20); // accepts up to 20 characters
        entryPanelUser.add(username);
        entryPanelUser.add(usernameEntryField);

        //middle panel with text field password
        JPanel entryPanelPassword = new JPanel();
        JLabel password = new JLabel("Password: ");
        JTextField passwordEntryField = new JTextField(20); // accepts up to 20 characters
        entryPanelPassword.add(password);
        entryPanelPassword.add(passwordEntryField);

        //middle panel

        JLabel feedback = new JLabel("Feedback");


        //bottom panel
        JPanel submitPanel = new JPanel();
        JButton submit = new JButton("Log In");
        JButton newAccount = new JButton("Create New Account");
        submitPanel.add(submit);
        submitPanel.add(newAccount);

        JPanel p = new JPanel((new GridBagLayout()));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy =1;
        p.add(entryPanelUser, c);
        c.gridx = 0;
        c.gridy = 2;
        p.add(entryPanelPassword, c);
        c.gridx = 0;
        c.gridy = 3;
        p.add(feedback,c);



        //Adding Components to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(p, BorderLayout.CENTER);
        frame.add(submitPanel, BorderLayout.SOUTH);

        // PART 2 -- SET UP EVENT HANDLING
        //setting up buttons to use ActionListener interface and actionPerformed method
//        submit.addActionListener(this);
//        newAccount.addActionListener(this);


        // showing the frame
        frame.pack();
        frame.setVisible(true);


    }

//
//    public void actionPerformed(ActionEvent e) {
//        JButton button = (JButton) (e.getSource());  // cast source to JButton
//        String text = button.getText();
//
//        if (text.equals("Submit")) {
//
//
//            String zipCode = weatherEntryField.getText();
//            updateDisplayPanel(zipCode);
//
//        }
//
//        //clears it
//        else if (text.equals("Clear")) {
//            weatherEntryField.setText("");
//            temperature.setText("");
//            condition.setText("");
//            currentWeather = null;
//            pictureLabel.setIcon(new ImageIcon("src/placeholder.jpg"));
//
//
//
//
//        }
//    }
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
//    public void itemStateChanged(ItemEvent e) {
//        JCheckBox box = (JCheckBox) (e.getSource());
//        if (box.isSelected() && currentWeather != null) {
//            temperature.setText("Temperature: " + currentWeather.getCurrentC() + " C°");
//        } else if (!box.isSelected() && currentWeather != null) {
//            temperature.setText("Temperature: " + currentWeather.getCurrentF() + " F°");
//        }
//    }
}
