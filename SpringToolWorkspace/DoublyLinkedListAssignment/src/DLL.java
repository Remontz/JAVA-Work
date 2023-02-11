import java.util.ArrayList;

public class DLL {
	public Node head;
	public Node tail;

	public DLL() {
		this.head = null;
		this.tail = null;
	}

	public void push(Node newNode) {
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}

	public void printValuesBackward() {
		Node current = this.tail;

		while (current != null) {
			System.out.println("\n" + current.value);
			current = current.previous;
		}
	}

	public Node pop() {
		Node removedNode = this.tail;
		this.tail = removedNode.previous;
		this.tail.next = null;

		return removedNode;
	}

	public boolean contains(Integer val) {
		// This method returns a boolean whetehr the value in the argument is in the
		// list or not. Return true if the value exists, else return false.
		Node current = this.head;
		boolean hasValue = false;

		while (current != null) {
			if (current.value == val) {
				System.out.println(current.value + val);
				hasValue = true;
				break;
			} else {
				hasValue = false;
			}

			current = current.next;
		}
		return hasValue;
	}

	public void insertAt(int value, int index) {
		// Inserts a node at a specific index. For example, let's say that we have 3
		// nodes in our list. If we call insertAt(newNode, 1), the newNode should be
		// inserted right after the head(head is index 0)
		// Node current = this.head;
		// int counter = this.size();

		Node newNode = new Node(value);

		if (index == 0) {
			newNode.next = this.head;
			head.previous = newNode;
			head = newNode;
		} else {
			Node runner = head;

			for (int i = 0; i < index - 1; i++) {
				if (runner != null) {
					runner = runner.next;
				}
			}

			newNode.next = runner.next;
			newNode.previous = runner;
			runner.next = newNode;
			if (newNode.next != null) {
				newNode.next.previous = newNode;
			}
		}
	}

	public int size() {
		// returns the number of nodes in the list.
		Node current = this.head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

}
