package Heap;

import Sorting.QuickSort;

public class Heap  {
    int[] heap;
    int size = 0;

    /***
     * 2 case to restore heap order:
     * 1/ New node is added at bottom of heap -> travel up to restore heap
     * 2/ replace root with new node of small value -> travel down the heap to restore heap order
     */

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

    public static void exchangeSort(int[] a, int left,int right){
        int temp = a[left - 1];
        a[left - 1] = a[right - 1];
        a[right - 1] = temp;
    }

    /***Case 1 child > parent
     * Time: O(logN) since it will run at most through the heigh of tree
     */
    // swim from the new inserted element to its parent
    public void heapifyBottomUp(int position){
        // if the position bigger than 1 which is the max root element
        // If the element at current position is bigger then its parent at position/2
        while(position > 1 && less(position/2 ,position)){
            // swap the child to its parent position and parent become child
            exchange(position/2,position);
            // update the position to the parent position
            position = position / 2;
        }
    }

    /***
     * Time: O(logN)
     */
    public void insert(int key){
        heap[++size] = key;
        /***
         * since we insert new key at the end then we need to check
         * heap order from bottom up
         */
        heapifyBottomUp(size);
    }

    public boolean less(int i, int j){ return heap[i] < heap[j];}

    /***
     * Time: O(logN) since it will run at most through the heigh of tree
     * Case 2:  parent < child
     * @param maxPosition
     */
    // heapify from the top down where maxPosition = parentPositio
    // main function when deleting the max element in the beginning
    public void heapifyTopDown(int maxPosition){
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

    /***
     * Time: O(logN)
     */
    // remove the max
    public int delMax(){
        // max element will always be at the first index
        int max = heap[1];
        // swap the first element with the last element
        exchange(1,size--);
        // delete the max element at the end of the list
        heap[size + 1] = 0;
        /***
         * since we just delete from the root -> we have to check from top-down with sink
         *  if heap is in right order
         *   put the swap element back to its place
         */
        heapifyTopDown(1);
        return max;
    }

    public void print()
    {
        for (int i = 1; i <= size ; i++) {
            System.out.print( heap[i] + " " );
        }
        System.out.println();
    }

    public void heapifyTopDownSort(int[] array, int parent, int size){
        /***
         * check for 1st child if smaller then size
         */
        while(2*parent <= size ){
            // obtain value of 1st child
            int firstChild = parent*2;
            // check with the value of 2nd child, we have to minus 1 since the array count the 0 index
            // but the heap not
            if(firstChild < size && array[firstChild - 1] < array[firstChild ]) firstChild++;
            // if the firstChild is in the right place
            if(array[parent - 1] > array[firstChild -1]) break;
            // if not then exchange 1st child with parent
            exchangeSort(array,parent,firstChild);
            // set parent to child
            parent = firstChild;
        }
    }


    /***
     * rarely used in application since it has poor cache performance -> array entries not compare with nearby
     * array entries
     * Time: O(NlogN)
     * Space: O(1)
     */
    public void heapSort(int[] arr){
        int arrayLength  = arr.length;
        // time: logN
        // compare parent with child to put the parent in the right order
        for(int parent = arrayLength/2; parent >= 1; parent--) heapifyTopDownSort(arr,parent,arrayLength);

        // time: NlogN
        while(arrayLength > 1){
            // put the max element at the first index and exchange element
            // in the increasing order
            exchangeSort(arr,1,arrayLength--);
            // heapify top down to put the parent in right order
            heapifyTopDownSort(arr,1,arrayLength);
        }
    }



    public static void main(String[] args){
        Heap heap = new Heap(8);
        heap.insert(11);
        heap.insert(5);
        heap.insert(6);
        heap.insert(3);
        heap.insert(9);
        heap.insert(1);
       // heap.delMax();
        heap.print();
//        int[] arr = {4,52,6,1,0,98,9};
//        heap.heapSort(arr);
//        for(int n: arr) System.out.print(n+",");

    }


}
