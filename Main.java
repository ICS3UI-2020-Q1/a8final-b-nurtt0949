import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel counterLabel;

  JTextField numberInput;

  JButton countButton;
  JButton resetButton;

  int count = 0;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize the mainJPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);
    //create the labels
    counterLabel = new JLabel("Counter:");
    //layout the labels with their cordiantes and size
    counterLabel.setBounds(50,250,200,30);
    //add label to main main panel
    mainPanel.add(counterLabel);
    //initialize the text fields
    numberInput = new JTextField("0");
    //layout the text fields with their cordinates and size
    numberInput.setBounds(125,250,200,30);
    //add text field to the main panel
    mainPanel.add(numberInput);
    //disable the text areas so the user cant type in them
    numberInput.setEnabled(false);
    //initialize the buttons
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");
    //layout the buttons with their cordinates and size
    countButton.setBounds(50,175,100,20);
    resetButton.setBounds(175,175,100,20);
    //add action listener to the buttons
    countButton.addActionListener(this);
    resetButton.addActionListener(this);
    //add buttons to the main panel
    mainPanel.add(countButton);
    mainPanel.add(resetButton);
    //add main panel to frame
    frame.add(mainPanel); 

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    if(command.equals("Count")){
      count++;
      numberInput.setText("" + count);
    
    if(count == 10){
      countButton.setEnabled(false);
    
    }
    }
    
    if(command.equals("Reset")){
      numberInput.setText("0");
      countButton.setEnabled(true);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
