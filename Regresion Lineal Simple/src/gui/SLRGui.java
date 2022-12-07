package gui;

import agents.myAgent;
import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SLRGui extends JFrame {	
	private myAgent myAgent;
	
	private JTextField priceField;
	
	public SLRGui(myAgent a) {
            super(a.getLocalName());

            myAgent = a;

            JPanel p = new JPanel();
            p.setLayout(new GridLayout(2, 2));
            p.add(new JLabel("Porcentaje:"));
            priceField = new JTextField(15);
            p.add(priceField);
            getContentPane().add(p, BorderLayout.CENTER);

            JButton addButton = new JButton("Predecir"); //Button
            addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                            try {
                                    String price = priceField.getText().trim();
                                    myAgent.predict(Double.parseDouble(price));
                                    priceField.setText("");
                            }
                            catch (Exception e) {
                                    JOptionPane.showMessageDialog(SLRGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
                            }
                    }
            } );
            p = new JPanel();
            p.add(addButton);
            getContentPane().add(p, BorderLayout.SOUTH);

            //Cerramos el agente cuando cierra ventana el usuario	
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