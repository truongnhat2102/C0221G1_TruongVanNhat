package bai11_stack_queue.exercise.reverse_stack;

import bai10_dsa_list.exercise.array_list.MyList;

import java.util.LinkedList;


public class MyGenericStack<T> {
    private LinkedList<T> stack;
    public MyGenericStack() {
        stack = new LinkedList<T>();
    }
    protected void reverse(){
        LinkedList<T> newStack = new LinkedList<>();
        int length=size();
        for (int i = 0; i < length; i++) {
            newStack.addFirst(stack.pop());
        }
        for (int i = 0; i < length; i++) {
            stack.addLast(newStack.get(i));
        }
    }
    public int size() {
        return stack.size();
    }

    public void push(T element) {
        stack.addFirst(element);
    }
    public T get(int index){
        T temp=stack.get(index);
        return temp;
    }
}
class MyGenericStackTest{
    public static void main(String[] args) {
        MyGenericStack<Integer> stack= new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.reverse();
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
        }
//        stack.reverse();
//        System.out.println();
//        for (int i = 0; i < stack.size(); i++) {
//            System.out.print(stack.get(i));
//        }
    }
}
