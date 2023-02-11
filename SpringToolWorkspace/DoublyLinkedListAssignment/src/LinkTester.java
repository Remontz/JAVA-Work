
public class LinkTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL d1 = new DLL();

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		d1.push(n2);
		d1.push(n3);
		d1.push(n4);
		d1.push(n5);
		d1.push(n1);
		d1.printValuesBackward();
		System.out.println("just popped: " + d1.pop().value);
		d1.printValuesBackward();

		System.out.println("Nine " + d1.contains(9));
		System.out.println("Three " + d1.contains(3));
		System.out.println("Size: " + d1.size() + "nodes.");

		System.out.println("Inserting 10 into index 3...starting DLL: ");
		d1.printValuesBackward();
		Node n10 = new Node(10);
		System.out.println(" newNode: " + n10.value);
		d1.insertAt(n10, 3);
		System.out.println("DLL is now: ");
		d1.printValuesBackward();
	}

}
