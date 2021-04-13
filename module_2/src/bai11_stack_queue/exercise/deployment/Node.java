package bai11_stack_queue.exercise.deployment;

class Node {
    int data;
    Node link;
}

class Queue {
    Node front, rear;

    // Function to create Circular queue
    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.link = temp;

        q.rear = temp;
        q.rear.link = q.front;
    }

    // Function to delete element from Circular Queue
    static int deQueue(Queue q) {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        // If this is the last node to be deleted
        int value; // Value to be dequeued
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else  // There are more than one nodes
        {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }

        return value;
    }

    // Function displaying the elements of Circular Queue
    static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.println(" Elements in Circular Queue are: ");
        while (temp.link != q.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }
}

class QueueTest {
    public static void main(String args[]) {
        // Create a queue and initialize front and rear
        Queue q = new Queue();
        q.front = q.rear = null;

        // Inserting elements in Circular Queue
        q.enQueue(q, 14);
        q.enQueue(q, 22);
        q.enQueue(q, 6);

        // Display elements present in Circular Queue
        q.displayQueue(q);

        // Deleting elements from Circular Queue
        System.out.printf(" Deleted value = %d", q.deQueue(q));
        System.out.println();
        System.out.printf(" Deleted value = %d", q.deQueue(q));
        System.out.println();

        // Remaining elements in Circular Queue
        q.displayQueue(q);

        q.enQueue(q, 9);
        q.enQueue(q, 20);
        q.displayQueue(q);

    }
}
