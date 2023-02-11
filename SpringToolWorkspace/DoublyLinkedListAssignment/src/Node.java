import java.util.function.IntFunction;

public class Node {
	public Integer value;
	public Node previous;
	public Node next;

	public Node() {
		this.value = null;
		this.previous = null;
		this.next = null;
	}

	public Node(int value) {
		// code here
		this.value = value;
		this.previous = null;
		this.next = null;
	}
}
