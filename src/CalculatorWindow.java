import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
         JPanel SymbolsGrid = new JPanel();

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

         //Set up grid lay out for symbols
         GridLayout SymbolsLayOut = new GridLayout(5,4);

         //Create buttons for upper layout



         SymbolsGrid.setLayout(SymbolsLayOut);
         String[][] buttonLabels = {
                 {"C", "()", "%", "/"},
                 {"7", "8", "9", "*"},
                 {"4", "5", "6", "-"},
                 {"1", "2", "3", "+"},
                 {"","0", ".", "="}
         };

         // Create and add buttons to the SymbolsGrid
         for (String[] row : buttonLabels) {
              for (String label : row) {
                   JButton button = new JButton(label);
                   SymbolsGrid.add(button);
                   if(Objects.equals(label, "C")){
                        button.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  ButtonAffect.Clear(InputText);
                             }
                        });
                   }
                   else if(Objects.equals(label, "=")){
                        button.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  double result = ButtonAffect.calculate(InputText.getText());
                                  OutputText.setText(String.valueOf(result));
                             }
                        });
                   }else{
                        button.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                  ButtonAffect.AppendNumber(InputText,button);
                             }
                        });
                   }

              }
         }



         InputTextBar.setBounds(0,0, 280, 50);
         OutputTextBar.setBounds(0,50, 280, 50);
         SymbolsGrid.setBounds(0, 100, 280, 360);
         setLayout(null);

         add(InputTextBar);
         add(OutputTextBar);
         add(SymbolsGrid);
         setVisible(true);
    }
}
