package thermodynamicSimulator;


import java.awt.event.*;
import javax.swing.*;

public class HeatPanel extends JPanel implements ActionListener
{
	public static final String EDIT = "edit";
	private static final long serialVersionUID = 1L;
	private static final String MASS = "MASS";
	private static final String HEAT = "HEAT";
	private static final String TIME = "TIME";
	
	private JLabel massLabel, heatLabel, timeLabel;
	private JButton massButton, heatButton, timeButton;
	private JPanel massPanel, heatPanel,timePanel;
	private Heat heat;
	
	public HeatPanel(Heat heat) {
		super();
		this.heat = heat;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		massLabel = new JLabel("Mass = " + heat.getMass() + " N");
		heatLabel = new JLabel("Heat = " + heat.getHeat() + "°");
		timeLabel = new JLabel("Time = " + heat.getTime() + "°");
		
		massButton = new JButton(EDIT);
		heatButton = new JButton(EDIT);
		timeButton = new JButton(EDIT);
		
		massButton.setActionCommand(MASS);
		heatButton.setActionCommand(HEAT);
		timeButton.setActionCommand(TIME);
		
		massButton.addActionListener(this);
		heatButton.addActionListener(this);
		timeButton.addActionListener(this);
		
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
		
		timePanel = new JPanel();
		timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
		timePanel.add(timeLabel);
		timePanel.add(Box.createHorizontalGlue());
		timePanel.add(timeButton);
		timePanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		add(massPanel);
		add(heatPanel);
		add(timePanel);
		
		setBorder(BorderFactory.createTitledBorder(heat.name.toUpperCase()));
		setBounds(5, 0, 300, 120);
	}
	
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
					massLabel.setText("Mass = " + heat.getMass() + " N");
					break;
				case HEAT:
					float oldHeat = heat.getHeat();
					float newHeat = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new magnitude", "Edit Force", JOptionPane.QUESTION_MESSAGE, null, null, oldHeat).toString());
					if(newHeat == oldHeat) { return; }
					heat.setHeat(newHeat);
					heatLabel.setText("Heat = " + heat.getHeat() + " N");
					break;
				case TIME:
					float oldTime = heat.getTime();
					float newTime = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new vector", "Edit Force", JOptionPane.QUESTION_MESSAGE, null, null, oldTime).toString());
					if(newTime == oldTime) { return; }
					heat.setTime(newTime);
					timeLabel.setText("Time = " + heat.getTime() + "°");
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
