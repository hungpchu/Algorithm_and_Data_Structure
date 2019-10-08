package Heap;

public class Heap {
    int[] heap;
    int size = 0;

    /***
     * max heap will always start from 1 since 2*1 = 2 and 2*1 + 1 = 3
     * Otherwise, if start at 0 then 2*0 = 0 and 2*0+ 1 = 1 which is not true since first child can not be in
     * the same index with parent which is 0.
     * @param size
     */
    public Heap(int size){
        heap = new int[size];
    }

    public int size(){ return size;}

    public void exchange(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // swim from the new inserted element to its parent
    public void swim(int position){
        // if the position bigger than 1 which is the max root element
        // If the element at current position is bigger then its parent at position/2
        while(position > 1 && less(position/2 ,position)){
            // swap the child to its parent position and parent become child
            exchange(position/2,position);
            // update the position to the parent position
            position = position / 2;
        }
    }

    public void insert(int key){
        heap[++size] = key;
        swim(size);
    }

    public boolean less(int i, int j){ return heap[i] < heap[j];}

    // heapify from the top down
    // main function when deleting the max element in the beginning
    public void sink(int maxPosition){
        // check first child position of max
        while(2 * maxPosition <= size){
            int firstchildPosition = 2 * maxPosition;
            // if the second child is bigger then 1st child then get 2nd child position
            if(firstchildPosition < size && less(firstchildPosition,firstchildPosition + 1)) firstchildPosition++;
            // if the parent is bigger then first Child then break since the heap is in right order
            if(!less(maxPosition,firstchildPosition)) break;
            // else the heap is not in right order then restore firstChild which is bigger to be parent
            exchange(maxPosition,firstchildPosition);
            // increase the position of maxPosition to firstChild position
            maxPosition = firstchildPosition;
        }
    }

    // remove the max
    public int delMax(){
        // max element will always be at the first index
        int max = heap[1];
        // swap the first element with the last element
        exchange(1,size--);
        // delete the max element at the end of the list
        heap[size + 1] = 0;
        // put the swap element back to its place
        sink(1);
        return max;
    }

    public void print()
    {
        for (int i = 1; i <= size ; i++) {
            System.out.print( heap[i] + " " );
        }
        System.out.println();
    }

    public static void main(String[] args){
        Heap heap = new Heap(8);
        heap.insert(11);
        heap.insert(5);
        heap.insert(6);
        heap.insert(3);
        heap.insert(9);
        heap.insert(1);
        heap.delMax();
        heap.print();

    }


}
