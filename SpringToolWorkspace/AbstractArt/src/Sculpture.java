
public class Sculpture extends Art {
	private String material;
	
	public Sculpture() {
		super();
		material = getMaterial();
	}
	
	public void viewArt() {
		System.out.println("Title: " + title);
		System.out.println("Artist: " + author);
		System.out.println("The material used to create this piece was: " + material + "Description" + description);
	}
	
	//getters and setters
		public String getTitle() {
			return title;
		}
		public void setTitle(String thisTitle) {
			title = thisTitle;
		}
		
		public String getArtist() {
			return author;
		}
		public void setArtist(String artist) {
			author = artist;
		}
		
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String typeMaterial) {
			material = typeMaterial;
		}
		
		public String description() {
			return description;
		}
		public void setDescription(String thisDescription) {
			description = thisDescription;
		}
}
