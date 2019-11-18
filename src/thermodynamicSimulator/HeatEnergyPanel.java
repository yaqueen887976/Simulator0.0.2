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
		
		energyLabel = new JLabel("Change In Tempreture = " + (float)Renderer.changeInTempreture +" K");
		//vectorLabel = new JLabel("Net Vector = " + (float)Renderer.netVector +"°");
		
		add(energyLabel);
		setBorder(BorderFactory.createTitledBorder("Change In Tempreture"));
		setBounds(300, 520, 250, 40);
	}
}
