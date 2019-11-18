package thermodynamicSimulator;


import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author yaqin
 *	Purpose: Get the left corner Mass, Heat and Energy Panel that can be modified
 */
public class HeatPanel extends JPanel implements ActionListener
{
	public static final String EDIT = "edit";
	private static final long serialVersionUID = 1L;
	private static final String MASS = "MASS";
	private static final String HEAT = "HEAT";
	private static final String ENERGY = "ENERGY";
	
	private JLabel massLabel, heatLabel, energyLabel;
	private JButton massButton, heatButton, energyButton;
	private JPanel massPanel, heatPanel,energyPanel;
	private Heat heat;
	
	public HeatPanel(Heat heat) {
		super();
		this.heat = heat;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		massLabel = new JLabel("Mass = " + heat.getMass() + " kg");
		heatLabel = new JLabel("Heat = " + heat.getHeat() + " J/kg*k");
		energyLabel = new JLabel("Energy = " + heat.getEnergy() + " J");
		
		massButton = new JButton(EDIT);
		heatButton = new JButton(EDIT);
		energyButton = new JButton(EDIT);
		
		massButton.setActionCommand(MASS);
		heatButton.setActionCommand(HEAT);
		energyButton.setActionCommand(ENERGY);
		
		massButton.addActionListener(this);
		heatButton.addActionListener(this);
		energyButton.addActionListener(this);
		
		massPanel = new JPanel();
		massPanel.setLayout(new BoxLayout(massPanel, BoxLayout.X_AXIS));
		massPanel.add(massLabel);
		massPanel.add(Box.createHorizontalGlue());
		massPanel.add(massButton);
		massPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		heatPanel = new JPanel();
		heatPanel.setLayout(new BoxLayout(heatPanel, BoxLayout.X_AXIS));
		heatPanel.add(heatLabel);
		heatPanel.add(Box.createHorizontalGlue());
		heatPanel.add(heatButton);
		heatPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		energyPanel = new JPanel();
		energyPanel.setLayout(new BoxLayout(energyPanel, BoxLayout.X_AXIS));
		energyPanel.add(energyLabel);
		energyPanel.add(Box.createHorizontalGlue());
		energyPanel.add(energyButton);
		energyPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		add(massPanel);
		add(heatPanel);
		add(energyPanel);
		
		setBorder(BorderFactory.createTitledBorder(heat.name.toUpperCase()));
		setBounds(5, 0, 300, 120);
	}
	
	// Check if edited value is a valid float number, and change it if it's a valid value
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		try
		{
			switch(action)
			{
				case MASS:
					float oldMass = heat.getMass();
					float newMass = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new magnitude", "Edit Force", JOptionPane.QUESTION_MESSAGE, null, null, oldMass).toString());
					if(newMass == oldMass) { return; }
					heat.setMass(newMass);
					massLabel.setText("Mass = " + heat.getMass() + " kg");
					break;
				case HEAT:
					float oldHeat = heat.getHeat();
					float newHeat = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new magnitude", "Edit Force", JOptionPane.QUESTION_MESSAGE, null, null, oldHeat).toString());
					if(newHeat == oldHeat) { return; }
					heat.setHeat(newHeat);
					heatLabel.setText("Heat = " + heat.getHeat() + " (Units J/kg*k)");
					break;
				case ENERGY:
					float oldEnergy = heat.getEnergy();
					float newEnergy = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new vector", "Edit Force", JOptionPane.QUESTION_MESSAGE, null, null, oldEnergy).toString());
					if(newEnergy == oldEnergy) { return; }
					heat.setEnergy(newEnergy);
					energyLabel.setText("Energy = " + heat.getEnergy() + " (Joules, J)");
					break;
					default: break;
			}
		}
		catch(NumberFormatException nfe) { JOptionPane.showMessageDialog(Main.frame, "Input was an invalid number", "Invalid Input", JOptionPane.WARNING_MESSAGE, null); }
		catch(NullPointerException npe) {  }
		finally
		{
			Main.screenPanel.setVisible(false);
			Main.screenPanel.revalidate();
			Main.screenPanel.repaint();
			Main.screenPanel.setVisible(true);
		}
	}
}
