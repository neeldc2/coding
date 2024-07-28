package stackandqueue;

public class QueueUsingLinkedList {
    QueueNode Front = null;
    QueueNode Rear = null;
    int size = 0;

    public boolean Empty() {
        return Front == null;
    }

    public int Peek() {
        if (Empty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else
            return Front.val;
    }

    public void Enqueue(int value) {
        QueueNode Temp;
        Temp = new QueueNode(value);
        if (Temp == null)  //When heap exhausted
            System.out.println("Queue is Full");
        else {
            if (Front == null) {
                Front = Temp;
                Rear = Temp;
            } else {
                Rear.next = Temp;
                Rear = Temp;
            }
            System.out.println(value + " Inserted into Queue ");
            size++;
        }
    }

    public void Dequeue() {
        if (Front == null)
            System.out.println("Queue is Empty");
        else {
            System.out.println(Front.val + " Removed From Queue");
            QueueNode Temp = Front;
            Front = Front.next;
            size--;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.Enqueue(10);
        queueUsingLinkedList.Enqueue(20);
        queueUsingLinkedList.Enqueue(30);
        queueUsingLinkedList.Enqueue(40);
        queueUsingLinkedList.Enqueue(50);
        queueUsingLinkedList.Dequeue();
        System.out.println("The size of the Queue is " + queueUsingLinkedList.size);
        System.out.println("The Peek element of the Queue is " + queueUsingLinkedList.Peek());
    }
}

class QueueNode {
    int val;
    QueueNode next;

    QueueNode(int data) {
        val = data;
        next = null;
    }
}
