import java.util.HashMap;
import java.util.Set;

public class TestHash {

    public static void main(String[] args) {
        Hash appTest = new Hash();

        HashMap<String, String> songs = new HashMap<String, String>();
        songs.put("Bones",
                "I got this feeling in my soul / Go ahead and throw your stones / 'Cause there's magic in my bones");
        songs.put("Young Volcanoes", "When Rome's in ruins, we are the lions / Free of the Colosseums");
        songs.put("Centuries", "Some legends are told, some turn to dust or to gold / But you will remember me");
        songs.put("Banana Pancakes", "Song, is meant to keep you / From doing what you're supossed to");

        String one = songs.get("Young Volcanoes");
        System.out.println("Lyrics test: " + one);

        System.out.println("All Tracks w/ Lyrics.");
        Set<String> song = songs.keySet();
        for (String lyrics : song) {
            System.out.println(lyrics + ": " + songs.get(lyrics));
        }

    }
}