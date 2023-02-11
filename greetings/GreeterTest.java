public class GreeterTest {
    public static void main(String[] args) {

        Greeter g = new Greeter();
        String greeting = g.greet();
        String greetingWithName = g.greet("Ed");
        System.out.println(greetingWithName);
    }
}
