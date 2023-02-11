import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        String greeting = String.format("Hello %s.  Lovely to see you.", name);
        return greeting;
    }

    public String dateAnnouncement() {
        Date currentDate = new Date();
        String dateMessage = "The current date is " + currentDate;
        return dateMessage;
    }

    public String respondBeforeAlexis(String conversation) {
        String response = conversation;
        return response;
    }

    // NINJA BONUS
    // See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}