package thermodynamicSimulator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author yaqin
 * Purpose: Show the result of delta temperature on the right corner
 */
public class HeatEnergyPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public static JLabel energyLabel;
	 	
	public HeatEnergyPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		energyLabel = new JLabel("Change In Temperature = " + (float)Renderer.changeInTemperature +" K");
		//vectorLabel = new JLabel("Net Vector = " + (float)Renderer.netVector +"°");
		
		add(energyLabel);
		setBorder(BorderFactory.createTitledBorder("Change In Temperature"));
		setBounds(300, 520, 250, 40);
	}
}
