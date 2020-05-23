package MyIntLinkedList;

import com.company.MyIntArrayList;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void displayList(MyIntLinkedList list) {
        System.out.print("The list contains: [");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print( " "+list.get(i));

        }
        System.out.println(" ]");
    }
    public static void displayArray(int [] array){
        System.out.print("[");
        for(int i = 0; i<array.length; i++){
            System.out.print(" "+ array[i]);
        }
        System.out.print(" ]");
    }
        public static void main(String[] args){
        MyIntLinkedList list = new MyIntLinkedList();

        Scanner sc = new Scanner(System.in);
            System.out.println("Insert the size of the list");
            int size = sc.nextInt();
            System.out.println("Insert the elements in the list");
            for (int i = 0; i<size;i++){
               list.add( sc.nextInt());
            }
            displayList(list);

            // Adding elements at a specific index
            list.add(3,10);
            displayList(list);

            //Adding a new list in the current list

            MyIntLinkedList list2 = new MyIntLinkedList();
            list2.add(99);
            list2.add(98);
            list2.add(97);
            list2.add(96);
            list2.size();
            list.addAll(list2);
            displayList(list);

            //Adding the new list in the current list at a specific index

            list.addAll(2,list2);
            displayList(list);

            //Check if the list contains the number 99
            System.out.println("Check if the list contains the number 99");
            System.out.println(list.contains(99));

            System.out.println("The index of the number 99 is: ");
            System.out.println(list.indexOf(99));

            System.out.println("The size of the list is:");
            System.out.println(list.size());
            displayList(list);

            System.out.println("Clear the list");
            list.clear();
            displayList(list);

            list.add(13);
            list.add(98);
            list.add(97);
            list.add(13);
            displayList(list);

            System.out.println("The last index of 13 is:");
            int lastIndex = list.lastIndexOf(13);
            System.out.println(lastIndex);

            System.out.println("Transform the list in an array");

              int [] arr = list.toArray();

            System.out.print("The list is now an array like: ");
            displayArray(arr);


        }
    }

