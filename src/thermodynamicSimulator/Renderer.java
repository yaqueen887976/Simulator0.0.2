package thermodynamicSimulator;

import java.awt.Graphics;
import javax.swing.JFrame;
public class Renderer
{
	public static double heatEnergy = 0;
	private JFrame frame;
	public Renderer(JFrame frame) {
		this.frame = frame;
	}
	
	public void render() {
		Graphics g = frame.getGraphics();
		g.translate(500, 300);
		heatEnergy = 50;
		HeatEnergyPanel.energyLabel.setText("Net Force = " + (float)Renderer.heatEnergy +" N");
		
		
		g.dispose();
	}
}
