package heaps;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize];
        this.size = 0;
    }

    private void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void insert(int element) {
        size++;
        heap[size] = element;
        if (size == 1) {
            return;
        }

        int currentIndex = size;
        int parentIndex = currentIndex / 2;
        while (heap[parentIndex] < heap[currentIndex] && parentIndex > 0) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = currentIndex / 2;
        }
    }

    public void delete() {
        heap[1] = heap[size];
        size--;

        int currentIndex = 1;


        while (currentIndex <= size) {
            int leftChildIndex = 2 * currentIndex;
            int rightChildIndex = 2 * currentIndex + 1;

            // Determine the larger child
            int largestChildIndex = currentIndex;

            if (leftChildIndex <= size && heap[leftChildIndex] > heap[largestChildIndex]) {
                largestChildIndex = leftChildIndex;
            }

            if (rightChildIndex <= size && heap[rightChildIndex] > heap[largestChildIndex]) {
                largestChildIndex = rightChildIndex;
            }

            // If the current element is larger than both children, stop the loop
            if (largestChildIndex == currentIndex) {
                break;
            }

            // Swap with the larger child
            swap(currentIndex, largestChildIndex);
            currentIndex = largestChildIndex; // Move to the child's position
        }

    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        maxHeap.insert(50);
        maxHeap.display();
        maxHeap.insert(40);
        maxHeap.display();
        maxHeap.insert(100);
        maxHeap.display();
        maxHeap.insert(20);
        maxHeap.display();
        maxHeap.delete();
        maxHeap.display();
    }
}
