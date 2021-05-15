package bai11_stack_queue.exercise.check_palindrome;

import java.util.LinkedList;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str= "Able was I ere I saw Elba";
        LinkedList<Character> aQueue= new LinkedList<>();
        for (int i = 0; i < str.length()/2; i++) {
            aQueue.addLast(str.charAt(i));
            if (aQueue.peek().compareTo(str.charAt(str.length()-i-1))==-32 && !aQueue.isEmpty()){
                aQueue.pop();
            }
            else if (aQueue.peek().compareTo(str.charAt(str.length()-i-1))==0 && !aQueue.isEmpty()){
                aQueue.pop();
            }
            else if (aQueue.peek().compareTo(str.charAt(str.length()-i-1))==32 && !aQueue.isEmpty()){
                aQueue.pop();
            }
        }
        if (aQueue.isEmpty()){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
