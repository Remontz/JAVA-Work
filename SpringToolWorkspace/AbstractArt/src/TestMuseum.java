
public class TestMuseum {

	public static void main(String[] args) {
		Painting painting1 = new Painting("Title 1", "Artist1", "Spray Paint", "Surreal view of the Milky Way Galaxy...");
		Painting painting2 = new Painting();
		Painting painting3 = new Painting();
		Sculpture sculpture1 = new Sculpture();
		Sculpture sculpture2 = new Sculpture();
		
		Museum museum1 = new Museum();
		
		museum1.addArt(painting1);
		museum1.addArt(painting2);
		museum1.addArt(painting3);
		museum1.addArt(sculpture1);
		museum1.addArt(sculpture2);
		
		museum1.display();
	}

}
