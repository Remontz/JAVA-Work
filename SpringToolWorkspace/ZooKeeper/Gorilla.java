
public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("The gorilla has thrown something.");
		super.setEnergyLevel(super.getEnergyLevel() - 5);
	}
	public void eatBananas() {
		System.out.println("The gorilla eats a banana; delightfully satisfied.");
		super.setEnergyLevel(super.getEnergyLevel() + 10);
	}
	public void climb() {
		System.out.println("The gorilla climbs a tree.");
		super.setEnergyLevel(super.getEnergyLevel() - 10);
	}
	
}
