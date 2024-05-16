package guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db_objs.MyJDBC;
import db_objs.User;

/*
    This gui will allow user to login or launch the register gui
    This extends from the BaseFrame which emans we will need to define our own addGuiComponent()
 */

public class LoginGui extends BaseFrame{
    public LoginGui() {
        super("Banking App Login");

    }

    @Override
    protected void addGuiComponents() {
        // create banking app label
        JLabel bankingAppLabel = new JLabel("Banking Application");

        // set the location and size of the gui component
        bankingAppLabel.setBounds(0, 20,  super.getWidth(), 40);

        // change the font style
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        // center text in JLabel
        bankingAppLabel.setHorizontalAlignment(JLabel.CENTER); // set text to center

        // add to gui
        add(bankingAppLabel);

        // username label
        JLabel usernameLabel = new JLabel("Username:");

        // getWidth() return us the width of our frame which is about  420
        usernameLabel.setBounds(20, 120, getWidth() - 30, 24); // set location and size

        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20)); // change font style
        add(usernameLabel);

        // create username field
        JTextField usernameField = new JTextField(); // create a text field
        usernameField.setBounds(20, 160, getWidth() - 50, 40); // set location and size
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28)); // change font style
        add(usernameField); // add to gui

        // create password label
        JLabel passwordLabel = new JLabel("Password:");

        // getWidth() return us the width of our frame which is about  420
        passwordLabel.setBounds(20, 280, getWidth() - 50, 24); // set location and size
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20)); // change font style
        add(passwordLabel);

        // create password field
        JPasswordField passwordField = new JPasswordField(); // create a text field
        passwordField.setBounds(20, 320, getWidth() - 50, 40); // set location and size
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28)); // change font style
        add(passwordField); // add to gui

        // create login button
        JButton loginButton = new JButton("Login"); // create a button for login
        loginButton.setBounds(20, 460, getWidth() - 50, 40); // set location and size
        loginButton.setFont(new Font("Dialog", Font.BOLD, 20)); // change font style
        loginButton.setFocusable(false); // remove the focus from the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the username
                String username = usernameField.getText(); // get the text from the username field

                // get the password
                String password = String.valueOf(passwordField.getPassword()); // get the text from the password field

                // validate login
                User user = MyJDBC.validateLogin(username, password); // validate login

                // if user is null it means invalid otherwise it is not a valid account
                if (user != null){
                    // means valid login

                    // dispose this gui
                    LoginGui.this.dispose();

                    // launch bank app gui
                    BankingAppGui bankingAppGui = new BankingAppGui(user); // create a new bank app gui
                    bankingAppGui.setVisible(true); // make it visible

                    // show success dialog
                    JOptionPane.showMessageDialog(bankingAppGui, "Login Successfully!");
                } else {
                    // invalid login
                    JOptionPane.showMessageDialog(LoginGui.this, "Invalid Login!");
                    usernameField.setText(""); // clear the username field
                    passwordField.setText(""); // clear the password field

                }

            }


        });
        add(loginButton); // add to gui

        // create register label
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>"); // create a label
        registerLabel.setBounds(0, 510, getWidth() - 10, 30); // set location and size
        registerLabel.setFont(new Font("Dialog", Font.PLAIN, 20)); // change font style
        registerLabel.setHorizontalAlignment(JLabel.CENTER); // set text to center
        add(registerLabel); // add to gui


    }
    
}
