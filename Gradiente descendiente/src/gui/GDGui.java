package gui;

import agents.gradientAgent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GDGui extends JFrame {
    private gradientAgent myAgent;
    private JTextField priceField;
    
    public GDGui(gradientAgent a){
        super(a.getLocalName());
        myAgent = a;
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Factor: "));

            
        priceField = new JTextField(15);
        p.add(priceField);

        getContentPane().add(p, BorderLayout.CENTER);
        JButton addButton = new JButton("Predecir");
        addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                        try {
                                String x = priceField.getText().trim();
                                myAgent.predict(Double.parseDouble(x));
                                priceField.setText("");
                        }
                        catch (Exception e) {
                                JOptionPane.showMessageDialog(GDGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
                        }
                }
        } );
        p = new JPanel();
        p.add(addButton);
        getContentPane().add(p, BorderLayout.SOUTH);

        addWindowListener(new	WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                        myAgent.doDelete();
                }
        } );

        setResizable(true);
    }
    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int)screenSize.getWidth() / 2;
        int centerY = (int)screenSize.getHeight() / 2;
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
}