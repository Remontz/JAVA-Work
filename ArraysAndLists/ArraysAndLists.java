import java.util.ArrayList;

class ArraysAndLists {

    public static void main(String[] args) {
        int[] myArray = new int[5];

        myArray[0] = 4;
        myArray[1] = 8;
        myArray[2] = 12;
        myArray[3] = 16;
        myArray[4] = 20;

        System.out.println(myArray);

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        String[] fruits = { "banana", "pear", "papaya", "kiwi" };
        String temp = fruits[0];
        fruits[0] = fruits[fruits.length - 1];
        fruits[fruits.length - 1] = temp;

        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // Array Lists
        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList);
        myList.add(10);
        myList.add(11);
        System.out.println(myList);

        // Getters and Setters
        Integer num = myList.get(0);
        System.out.println(num);
        myList.set(0, 9);
        System.out.println(myList);

        ArrayList<Object> things = new ArrayList<Object>();
        things.add(10);
        things.add("Hello");
        things.add(new ArrayList<Integer>());
        things.add(23.5);
        System.out.println(things);
    }
}