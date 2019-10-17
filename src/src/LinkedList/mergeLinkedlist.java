package LinkedList;

// Java program to illustrate merge sorted
// of linkedList

class linkedList {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b)
    {
        node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    node merge(node left, node right){
        if(left == null) return right;
        if(right == null ) return left;
        node result = null;
            if (  left.val <  right.val) {
                result = left;
                result.next = merge(left.next,right);
            }else{
                result = right;
                result.next = merge(right.next,left);
            }

        return result;
    }

    node mergeSort(node h)
    {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(h);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = merge(left, right);
        return sortedlist;
    }


    // Utility function to get the middle of the linked list
    public static node getMiddle(node head)
    {
        if (head == null)
            return head;

        node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int new_data)
    {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Utility function to print the linked list
    void printList(node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    node removeNthFromEnd(node head, int n) {
        /***
         * 2 base cases: head = null then return null
         * there is only 1 node and delete at n = 1 then return null
         */
        if (head == null) return null;
        if(head.next == null && n == 1) return null;
        // oldHead to get to the delete position
        node oldHead = head;
        // last to get to the end of list and support the oldHead
        node last = head;
        // result to return at the begin of list
        node result = head;

        // loop through first n position node of the list
        int i = 0;
        while(i < n){
            last = last.next;
            i++;
        }

        // if last is not null then move last to the end of list
        // and move head to the listSize - n position at the end of list
        // then oldHead will be at the position of n
        while(last != null){
            // if last.next is null then link the oldHead to the next of next to skip or delete the wanted node
            if (last.next == null) {
                if(oldHead.next != null)  oldHead.next = oldHead.next.next;
                return result;
            }
            oldHead = oldHead.next;
            last = last.next;

        }
        // if the oldHead is not null then take the value of next of node deleted and link to the next of next
        // to avoid the duplicate
        if(oldHead.next != null){oldHead.val = oldHead.next.val;
            oldHead.next = oldHead.next.next;

        }
        return result;

    }



    public node mergeSortHungChu(node head){
        if(head == null ) return null;
        if(head.next == null ) return head;
        node left = head;
        node middle =  middle(head);
        node right = middle.next;
        while(head != middle) head = head.next;
        head.next = null;
        // until the end
        node leftStart = mergeSortHungChu(left);
        node rightStart = mergeSortHungChu(right);
        node result = sort(leftStart,rightStart);
        return result;
    }

    public node sort(node l1, node l2){
        // base case: if the 2 lists are null;
        if(l1 == null && l2 == null) return null;
        // if the l1 is null return l2;
        if(l1 == null) return l2;
        // if l2 is null then return l1;
        if(l2 == null ) return l1;
        // current for looping through list

        node current = new node(0);
        // check for the value of current
        if(l1.val < l2.val){
            current = l1;
            l1= l1.next;
        }
        else{
            current = l2;
            l2 = l2.next;
        }
        // store the head of current to result
        node result = current;
        // loop until both of l1 and l2 is null
        while(l1 != null || l2 != null){
            // if l1 is not null and l2 is null then return
            if(l2 == null && l1 != null) {
                current.next = l1;
                break;
            }else if(l1 == null && l2 != null){
                current.next = l2;
                break;
            }
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2=l2.next;
            }
            current = current.next;
        }
        return result;
    }

    public node middle(node head){
        if(head == null) return null;
        node middle = head;
        node last = head;
        while( last != null){
            if(last.next == null || last.next.next == null) return middle;
            middle = middle.next;
            last = last.next.next;
        }

        return middle;
    }
    public static void main(String[] args)
    {

        linkedList li = new linkedList();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        li.push(29);
        li.push(4);


        System.out.print(li.head.val);

        // Apply merge Sort
        li.head = li.mergeSortHungChu(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
//        System.out.println(" middle = " + li.middle(li.head).val);
    }
}

// This code is contributed by Rishabh Mahrsee
