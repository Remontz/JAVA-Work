
public class Mammal {
	private int energyLevel = 100;
	
	// Getters & Setters
	// get Energy Level
	public int getEnergyLevel() {
		return energyLevel;
	}
	// set Energy Level
	public void setEnergyLevel(int energy) {
		energyLevel = energy;
	}
	
	public int displayEnergy() {
		System.out.println(getEnergyLevel());
		return getEnergyLevel();
	}
}
