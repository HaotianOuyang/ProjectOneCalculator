import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {
    public CalculatorWindow(){
         setTitle("CalculatorOne");

         setSize(300,500);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setVisible(true);

         //Create panel one for Input text fields
         JPanel InputTextBar =  new JPanel();
         JPanel OutputTextBar = new JPanel();
         JPanel Symbols = new JPanel();

         //Set up Input Text bar
         JTextField InputText = new JTextField(("Please input your formula"));
         InputText.setFont(new Font("Arial", Font.PLAIN, 25));
         InputText.setPreferredSize(new Dimension(280,50));
         InputTextBar.add(InputText);

         //Set up output text bar
         JLabel OutputText = new JLabel("Result:");
         OutputText.setFont(new Font("Arial", Font.PLAIN, 25));
         OutputText.setPreferredSize(new Dimension(280,50));
         OutputTextBar.add(OutputText);

         InputTextBar.setBounds(0,0, 280, 50);
         OutputTextBar.setBounds(0,50, 280, 50);

         setLayout(null);

         this.add(InputTextBar);
         this.add(OutputTextBar);
         setVisible(true);
    }
}
