package thermodynamicSimulator;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author yaqin
 * Purpose: This class is for draw the center graph, and get
 * 			the result if other variable changed.
 */
public class Renderer
{
	public static double changeInTemperature = 0;
	private JFrame frame;
	//private BufferedImage img = null;
	private ImageIcon img = null;
	public Renderer(JFrame frame) {
		this.frame = frame;
	}
	
	public void render() {
		Graphics g = frame.getGraphics();
		g.translate(500, 300);
		
		ArrayList<Heat> heatArray = new ArrayList<>();
		for(int i = 1; i < HeatList.listModel.size(); i++) {
			heatArray.add(HeatList.heatMap.get(HeatList.listModel.elementAt(i)));
		}
		
		for(int i=0; i<heatArray.size(); i++) {
			float mass = heatArray.get(i).getMass();
			float heat = heatArray.get(i).getHeat();
			float energy = heatArray.get(i).getEnergy();
			
			//Q = cmt 
			//c is specific heat, m is mass of substance and t is change in tempreture
			changeInTemperature = energy/(heat*mass);
		}
		
		//img = ImageIO.read(new File("C:\\Users\\yaqin\\eclipse-workspace\\Simulator\\src\\thermodynamicSimulator\\graph.PNG" ));
		//img = ImageIO.read(new File("../graph.PNG" ));
		/*URL url = getClass().getResource("graph.PNG");
		File file = new File(url.getPath());
		img = ImageIO.read(file);*/
		
		//put the graph in the center
		img = new ImageIcon(this.getClass().getClassLoader().getResource("images/graph.PNG"));
		    
		//change the Temperature result if other variable changed
		HeatEnergyPanel.energyLabel.setText("Change in Temperature = " + (float)Renderer.changeInTemperature +" K");
		g.drawImage(img.getImage(),-200, -100,null);
		
		g.dispose();
	}
}
