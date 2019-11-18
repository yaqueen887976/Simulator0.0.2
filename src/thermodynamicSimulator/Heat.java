package thermodynamicSimulator;



public class Heat
{
	public String name;
	
	@SuppressWarnings(value = {"unused"})
	private float mass, heat, energy;
	
	public Heat(String name) {
		this.name = name;
		this.mass = 0;
		this.heat = 0;
		this.energy = 0;
	}
	
	public Heat(String name, float energy, float mass,float heat) {
		this(name);
		this.mass = mass;
		this.heat = heat;
		this.energy = energy;
	}
	
	public void setName(String par1) {this.name = par1;}
	public void setMass(float par1) {this.mass = par1;}
	public void setHeat(float par1) {this.heat = par1;}
	public void setEnergy(float par1) {this.energy = par1;}
	public float getMass() { return this.mass;}
	public float getHeat() { return this.heat;}
	public float getEnergy() { return this.energy;}
	
	public String toString() {return "Name: "+ this.name + "Mass: " + this.mass+"Heat: "+this.heat+"Energy: "+this.energy;}
	public Object clone() {return new Heat(this.name, this.mass, this.heat, this.energy);}
	
	
}
