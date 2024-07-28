package stackandqueue;

public class StackUsingLinkedList {

    StackNode top;
    int size;

    StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void stackPush(int x) {
        StackNode element = new StackNode(x);
        element.next = top;
        top = element;
        System.out.println("Element pushed");
        size++;
    }

    public int stackPop() {
        if (top == null) return -1;
        int topData = top.val;
        StackNode temp = top;
        top = top.next;
        return topData;
    }

    public int stackSize() {
        return size;
    }

    public boolean stackIsEmpty() {
        return top == null;
    }

    public void printStack() {
        StackNode current = top;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.stackPush(10);
        stackUsingLinkedList.stackPush(20);
        stackUsingLinkedList.printStack();
        System.out.println("Element popped " + stackUsingLinkedList.stackPop());
        System.out.println("Stack size: " + stackUsingLinkedList.stackSize());
        System.out.println("Stack is empty or not: " + stackUsingLinkedList.stackIsEmpty());
    }
    
}

class StackNode {
    int val;
    StackNode next;

    StackNode(int data) {
        val = data;
        next = null;
    }
}
