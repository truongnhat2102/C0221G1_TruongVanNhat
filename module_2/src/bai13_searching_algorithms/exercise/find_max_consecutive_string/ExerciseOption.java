package bai13_searching_algorithms.exercise.find_max_consecutive_string;

import bai10_dsa_list.exercise.linked_list.MyLinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ExerciseOption {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        // Find the maximum consecutive increasingly ordered substring
        for (int i = 0; i < string.length(); i++) { 		// single loop
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); // Simple statement
            }

            list.add(string.charAt(i)); // Simple statement

            if (list.size() > max.size()) { // Simple statement
                max.clear();
                max.addAll(list);
            }
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
    }
}
