
public class Bat extends Mammal {
	private boolean attackingTown;
	
	public Bat() {
		super.setEnergyLevel(300);
	}
	
	public void fly() {
		System.out.println("The bat has taken flight.");
		System.out.println("**Sound of giant bat wings**");
		super.setEnergyLevel(super.getEnergyLevel() - 50);
	}
	
	public void eatHumans() {
		while(attackingTown) {	
			System.out.println("The bat just ate a human!");
		attackingTown = false;
		super.setEnergyLevel(super.getEnergyLevel() + 25);
		}
		System.out.println("The bat must attack a town to eat...");
	}
	
	public void attackTown() {
		System.out.println("The bat is attacking a town!");
		System.out.println("**Attacked Town Sounds***");
		super.setEnergyLevel(super.getEnergyLevel() - 100);
		attackingTown = true;
	}
}
