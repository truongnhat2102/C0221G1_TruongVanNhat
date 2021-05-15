package bai11_stack_queue.exercise.check_bracket;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (((((s – c))))";
        Stack<Character> bStack= new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == '('){
               bStack.push(str.charAt(i));
           }
           else if (!bStack.isEmpty() && str.charAt(i)==')' && bStack.peek()=='('){
               bStack.pop();
           }
           else if (str.charAt(i)==')'){
               bStack.push(str.charAt(i));
           }
        }
        if (bStack.isEmpty()){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
