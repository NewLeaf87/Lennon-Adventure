import java.awt.Color;

import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.*;
import java.awt.GridLayout;

import java.awt.Font;

import java.awt.Container;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Fantasy", Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        // Making the window
        window = new JFrame();
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        // Title page
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Lennon's Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        // Start Button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        // the "START" button
        startButton = new JButton("Start"); // adding text to the start button
        startButton.setBackground(Color.black); // color of the background
        startButton.setForeground(Color.white); // color of the text
        startButton.setFont(normalFont);

        startButton.addActionListener(tsHandler);// added action listener to start game
        startButton.setFocusPainted(false); //removes extra white lines around text

        startButtonPanel.add(startButton);

        con.add(titleNamePanel); // adding title
        con.add(startButtonPanel); // adding start button
    }

    public void createGameScreen() {
        // must disable these panels to activate 
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // adding game screen panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area. This game is going top be great! Im sure of it");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); // Text will wrap if long text is used
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        //adding choice buttons to gamescreen
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choiceButtonPanel.add(choice1);
        choice1.addActionListener(choiceHandler);//handles choices made
        choice1.setActionCommand("c1");

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choiceButtonPanel.add(choice2);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choiceButtonPanel.add(choice3);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choiceButtonPanel.add(choice4);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        //adding player stats(HP weapon choice)
        playerPanel= new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        //HP
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        //HP Number
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        //weapon
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        //weapon name
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);
        //Calling the playerSetup Method
        playerSetup();



    }

    public void playerSetup() {
        playerHP = 15;
        weapon = "Dem Hands";
        weaponLabelName.setText(weapon);//displaying weapon name
        hpLabelNumber.setText("" + playerHP); //displaying HP

        townGate(); // calls townGate Method
    }
    public void townGate() {
        position = "townGate";// Will show player's place

        mainTextArea.setText("You are at the gate of the town.\n A Guard is standing in front of you.\n\n What do you do?");

        choice1.setText("Talk to the Guard");
        choice2.setText("Run the fade");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard(){
        position = "talkGuard";

        mainTextArea.setText("Hello there! I have never seen you in these parts?\n  I cannot let you pass.\n Sorry bout that...");

        choice1.setText("Mean mug walk away");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position){
                case "townGate":
                switch(yourChoice){
                    case "c1": talkGuard(); break;
                    case "c2": break;
                    case "c3": break;
                }
                break;
                case "talkGuard":
                switch(yourChoice){
                    case "c1": townGate(); break;
                }
            }

        }
    }

    

}