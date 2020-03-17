package com.zhouxin;

public class Main {


    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray();
        for (int i = 0; i < 10; i++) {
            myArray.addLast(i);
        }

        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        myArray.addLast(12);
        myArray.addLast(12);
        myArray.addElement(2,33);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        System.out.println(myArray.get(2));

        myArray.set(10,101);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        System.out.println(myArray.contains(32));

        myArray.addElement(4,33);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);
        System.out.println(myArray.findAll(33)[0]);

        myArray.remove(1);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        myArray.removeElement(33);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        myArray.addElement(5,33);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        myArray.removeAllElement(33);
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);

        myArray.removeFirst();
        myArray.removeFirst();
        myArray.removeFirst();
        System.out.printf("Capacity:%d  Size:%d%n", myArray.getCapacity(), myArray.getSize());
        System.out.println(myArray);
    }


}
