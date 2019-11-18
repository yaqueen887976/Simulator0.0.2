package thermodynamicSimulator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Renderer
{
	public static double heatEnergy = 0;
	private JFrame frame;
	private BufferedImage img = null;
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
			float time = heatArray.get(i).getTime();
			heatEnergy = mass * heat * time;
		}
		
		try
		{
		    //img = ImageIO.read(new File("C:\\Users\\yaqin\\eclipse-workspace\\Simulator\\src\\thermodynamicSimulator\\graph.PNG" ));
		    //img = ImageIO.read(new File("../graph.PNG" ));
		    URL url = getClass().getResource("graph.PNG");
		    File file = new File(url.getPath());
		    img = ImageIO.read(file);
	
		}
		catch ( IOException exc )
		{
			System.out.println("warning");
		}
		    
		
		HeatEnergyPanel.energyLabel.setText("Net Force = " + (float)Renderer.heatEnergy +" N");
		
		g.drawImage( img, -200, -100, null );
		g.dispose();
	}
}
