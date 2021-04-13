package bai10_dsa_list.exercise.array_list;


public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    static Object elements[];

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    MyList(int capacity) {
        size = capacity;
        elements = new Object[size];
    }

    void add(int index, E element) {
        size++;
        for (int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    E remove(int index) {
        E element = null;
        for (int i = 0; i < size; i++) {
            if (i > index) {
                elements[i - 1] = elements[i];
            } else if (i == index) {
                element= (E) elements[i];
            }
        }
        size--;
        return element;
    }

    int size() {
        int count=0;
        for (int i = 0; i < size; i++) {
            if (elements[i]!=null){
                count++;
            }
        }
        return count;
    }

    protected E clone() {
        return (E) elements;
    }

    boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return true;
            }
        }
        return false;
    }

    int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    boolean add(E e) {
        size++;
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                elements[i] = e;
                return true;
            }
        }
        return false;
    }

    void ensureCapacity(int minCapacity) {

    }

    E get(int i) {
        return (E) elements[i];
    }

    void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

}

class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> arr = new MyList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(1,2);
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.print(arr.elements[i]+",");
//        }
        System.out.println(arr.remove(2));
        System.out.println(arr.contains(5));
        System.out.println(arr.indexOf(2));
        System.out.println(arr.get(2));
        int[] b=new int[arr.size()];
        arr.clear();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.elements[i] + ",");
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(b[i] + ",");
        }
    }
}
