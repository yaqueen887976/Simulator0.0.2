package thermodynamicSimulator;



public class Heat
{
	public String name;
	
	@SuppressWarnings(value = {"unused"})
	private float mass, heat, time;
	
	public Heat(String name) {
		this.name = name;
		this.mass = 0;
		this.heat = 0;
		this.time = 0;
	}
	
	public Heat(String name, float mass,float heat, float time) {
		this(name);
		this.mass = mass;
		this.heat = heat;
		this.time = time;
	}
	
	public void setName(String par1) {this.name = par1;}
	public void setMass(float par1) {this.mass = par1;}
	public void setHeat(float par1) {this.heat = par1;}
	public void setTime(float par1) {this.time = par1;}
	public float getMass() { return this.mass;}
	public float getHeat() { return this.heat;}
	public float getTime() { return this.time;}
	
	public String toString() {return this.name + ":" + this.mass+"@"+this.heat+this.time;}
	public Object clone() {return new Heat(this.name, this.mass, this.heat, this.time);}
	/*
	public boolean equals(Object obj) {
		if(obj instanceof Heat) {
			Heat objForce = (Heat)((Heat)obj).clone();
			return objForce.force == this.force && objForce.vector == this.vector ? true : false;
		}
		return false;
	}
	*/
	
	/*
	public Heat getCompForceX() {
		double newVector = this.vector;
		float x = (float)(Math.cos(Renderer.toRad(newVector))*getForce());
		return new Heat("",x,0);
	}
	
	public Heat getCompForceY() {
		double newVector = this.vector;
		float y = (float)(Math.sin(Renderer.toRad(newVector))*getForce());
		return new Heat("",y,90);
	}*/
}
