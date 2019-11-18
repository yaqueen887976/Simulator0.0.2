package thermodynamicSimulator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeatEnergyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public static JLabel energyLabel;
	 	
	public HeatEnergyPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		energyLabel = new JLabel("Heat Energy = " + 7 +" N");
		
		add(energyLabel);
		setBorder(BorderFactory.createTitledBorder("Test"));
		setBounds(330, 520, 250, 45);
	}
}
