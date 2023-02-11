
public class Painting extends Art {
	private String paintType;
	
	public Painting() {
		super();
		paintType = getPaintType();
	}
	public Painting(String title, String author, String paintType, String description) {
		super();
		setTitle(title);
		setArtist(author);
		setPaintType(paintType);
		setDescription(description);
	}
	
	public void viewArt() {
		System.out.println("Title: " + title);
		System.out.println("Artist: " + author);
		System.out.println("Paint type: " + paintType);
		System.out.println("Description:" + description);
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
	
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String typePaint) {
		paintType = typePaint;
	}
	
	public String description() {
		return description;
	}
	public void setDescription(String thisDescription) {
		description = thisDescription;
	}
}
