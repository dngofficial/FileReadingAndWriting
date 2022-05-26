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
    private JTextField usernameEntryField;
    private JTextField passwordEntryField;
    private JButton changeUsernameButton;
    private JButton changePasswordButton;
    private int currentIDxLogIn;


    public PasswordGUI() {
        feedback = new JLabel();
        username = new JLabel();
        password = new JLabel();
        logIn = new JLabel();
        personSaver = new PersonSaver();
        frame = new JFrame("PasswordSIM by Devan");
        currentIDxLogIn = -1;


        setupGui();
        changeToLogIn();


    }


    // private helper method, called by constructor
    // to set up the GUI and display it
    private void setupGui() {
        //Creating a Frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ends program when you hit the X

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
        usernameEntryField = new JTextField(20); // accepts up to 20 characters
        changeUsernameButton = new JButton("Change Username");
        entryPanelUser.add(username);
        entryPanelUser.add(usernameEntryField);
        entryPanelUser.add(changeUsernameButton);
//        changeUsernameButton.setVisible(false);


        //middle panel with text field password
        JPanel entryPanelPassword = new JPanel();
        password = new JLabel("Password: ");
        passwordEntryField = new JTextField(20); // accepts up to 20 characters
        changePasswordButton = new JButton("Change Password");
        entryPanelPassword.add(password);
        entryPanelPassword.add(passwordEntryField);
        entryPanelPassword.add(changePasswordButton);
//        changePasswordButton.setVisible(false);
        //middle panel

        feedback = new JLabel("");


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
        changeUsernameButton.addActionListener(this);
        changePasswordButton.addActionListener(this);


        // showing the frame
        frame.pack();
        frame.setVisible(true);


    }

    public void changeToCreateAccount() {

        passwordEntryField.setText("");
        usernameEntryField.setText("");
        feedback.setText("");
        username.setText("Create username (max 20 characters): ");
        password.setText("Create password (max 20 characters): ");
        logIn.setText("Create a new account");
        submit.setText("Create Account");
        newAccount.setText("Back");
        changePasswordButton.setVisible(false);
        changeUsernameButton.setVisible(false);
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);

    }

    public void changeToAccountEditor() {


        passwordEntryField.setText("");
        usernameEntryField.setText("");
        feedback.setText("");
        username.setText("Change current username (max 20 characters): ");
        password.setText("Create current password (max 20 characters): ");
        changeUsernameButton.setVisible(true);
        changePasswordButton.setVisible(true);
        logIn.setText("Change an account's info");
        submit.setText("Log Out");
        newAccount.setText("Delete Account");
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);

    }


    public void changeToLogIn() {

        passwordEntryField.setText("");
        usernameEntryField.setText("");
        feedback.setText("");
        username.setText("Username: ");
        password.setText("Password: ");
        logIn.setText("Enter username and password");
        submit.setText("Log In");
        newAccount.setText("Create New Account");
        changePasswordButton.setVisible(false);
        changeUsernameButton.setVisible(false);
        frame.setVisible(false);
        frame.pack();
        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());  // cast source to JButton
        String text = button.getText();

        if (text.equals("Create New Account")) {

            changeToCreateAccount();

        } else if (text.equals("Log In")) {
            verifyLogIn();
        } else if (text.equals("Create Account")) {
            accountCreationLogic();
        } else if (text.equals("Change Password")) {
            changePassword();
        } else if (text.equals("Change Username")) {
            changeUsername();
        } else if (text.equals("Back") || text.equals("Log Out")) {

            changeToLogIn();

        } else if (text.equals("Delete Account"))
        {

            personSaver.removeAccount(currentIDxLogIn);
           changeToLogIn();
            feedback.setText("Account successfully deleted.");
            frame.setVisible(false);
            frame.pack();
            frame.setVisible(true);


        }

}

        private void accountCreationLogic ()
        {
            String name = usernameEntryField.getText();
            String password = passwordEntryField.getText();


            if (name.contains(" ") || password.contains(" ") || password.equals("") || name.equals("")) {
                feedback.setText("You sure everything is properly filled in?");

            } else if (personSaver.findIdxOfNameInPersonList(name) == -1) {
                personSaver.addNewAccount(name, password);
                feedback.setText("New Account Created! Click back or create another account!");
            } else {
                feedback.setText("An account already exists with that name!");
            }

            frame.setVisible(false);
            frame.pack();
            frame.setVisible(true);
        }

        private void verifyLogIn ()
        {
            if (personSaver.checkIfValidAccount(usernameEntryField.getText(), passwordEntryField.getText())) {
                currentIDxLogIn = personSaver.findIdxOfNameInPersonList(usernameEntryField.getText());
                System.out.println("current account idx: " + currentIDxLogIn);
                changeToAccountEditor();

            } else if (!personSaver.checkIfValidAccount(usernameEntryField.getText(), passwordEntryField.getText()) && personSaver.findIdxOfNameInPersonList(usernameEntryField.getText()) != -1) {
                feedback.setText("Incorrect log in details.");
            } else {
                feedback.setText("Account not found.");
            }
            frame.setVisible(false);
            frame.pack();
            frame.setVisible(true);
        }

        private void changeUsername()
        {
            String name = usernameEntryField.getText();

            if (name.contains(" ") || name.equals("")) {
                feedback.setText("You sure everything is properly filled in?");

            } else if (personSaver.findIdxOfNameInPersonList(name) == -1 && !personSaver.returnNameInList(currentIDxLogIn).equals(name)) {
                personSaver.changeNameOfUserInList(currentIDxLogIn, name);
                feedback.setText("Username updated!");
            } else {
                feedback.setText("Account name taken already.");
            }

            frame.setVisible(false);
            frame.pack();
            frame.setVisible(true);
        }

        private void changePassword()
        {
            String password = passwordEntryField.getText();

            if (password.contains(" ") || password.equals("")) {
                feedback.setText("You sure everything is properly filled in?");

            } else if (!personSaver.returnPasswordInList(currentIDxLogIn).equals(password)) {
                personSaver.changePasswordOfUserInList(currentIDxLogIn, password);
                feedback.setText("Password updated!");
            } else {
                feedback.setText("That's the same password as before!");
            }

            frame.setVisible(false);
            frame.pack();
            frame.setVisible(true);
        }



}