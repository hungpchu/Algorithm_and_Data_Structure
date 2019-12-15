package Heap;

import java.util.ArrayList;
import java.util.List;

class PriorityQueue {

    public int size;
    public List<Integer> pq;

    // using list so we have dynamic size
    public PriorityQueue() {
        pq = new ArrayList<>();
        size = 0;
    }

    // always add at the index zero;
    public void insert(int element) {
        if(size == 0) pq.add(0,0);
        size++;
        pq.add(size, element);
        heapifyBottomUp(size);
    }

    public void exchange(List<Integer> pq, int left, int right) {
        int temp = pq.get(right);
        pq.set(right, pq.get(left));
        pq.set(left, temp);
    }

    public void heapifyBottomUp(int position) {
        // if the child Node is bigger then parent node
        while (position > 1 && pq.get(position) > pq.get(position / 2)) {
            exchange(pq, position, position / 2);
            position = position / 2;
        }
    }

    public int remove() {
        pq.set(1, pq.get(size));
        int removeElement = pq.remove(size);
        size--;
        heapifyTopDown(1);
        return removeElement;
    }


    public void heapifyTopDown(int parent) {
        while (2 * parent <= size) {
            int firstChild = 2 * parent;
            if (firstChild < size && pq.get(firstChild) < pq.get(firstChild + 1)) firstChild++;
            if (pq.get(parent) > pq.get(firstChild)) break;
            exchange(pq, firstChild, parent);
            parent = firstChild;
        }
    }

    public void print()
    {
        for (int i = 1; i <= size ; i++) {
            System.out.print( pq.get(i) + " " );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        PriorityQueue heap = new PriorityQueue();
//        heap.insert(11);
//        heap.insert(5);
//        heap.insert(6);
//        heap.insert(3);
//        heap.insert(9);
//        heap.insert(1);

        heap.insert(0);
        heap.insert(3);
        heap.insert(4);
        heap.insert(-3);
        heap.insert(8);
        heap.insert(9);
       // heap.remove();
        heap.print();

    }

}

