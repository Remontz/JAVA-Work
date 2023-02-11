import java.util.ArrayList;
import java.util.Random;
public class Museum {
	public ArrayList<Art> museum = new ArrayList<Art>();
	
	public Museum() {
		museum = getMuseum(); 
	}
	
	public void addArt(Art artWork) {
		museum.add(artWork);
	}
	
	public ArrayList<Art> getMuseum() {
		return museum;
	}
	public void setMuseum(ArrayList<Art> museum) {
		this.museum = museum;
	}
	
	public void display() {
		for(int i = 0; i<museum.size(); i++) {
			Art artWork = museum.get(i);
			artWork.viewArt();
		}
	}
	public void shuffleAndDisplay() {
		Random random = new Random();
		ArrayList<Art> newMuseum = new ArrayList<Art>();
		int j;
		int mSize = museum.size();
		
		for (int i = 0; i < mSize; i++) {
			j=random.nextInt(mSize);
			newMuseum.add(museum.get(j));
			museum.remove(j);
		}
		this.museum = newMuseum;
		
		//Display
		display();
	}
}

	
