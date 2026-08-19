// Given the head of a linked list, rotate the list to the right by k places.

class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //first we get the length of list and get the values in an array
        if(head == null || head.next == null)
            return head;
        int max=1;
        ListNode auxiliarList = head;
        while(auxiliarList.next!=null)
        {
            max++;
            auxiliarList = auxiliarList.next;
        }
        //we are dividing k to the length to get the real number of movements
        int rotations = k % max;
        if ( rotations == 0)
            return head;
        
        //we create a cycle, and we will stop it in the rotation indicated
        auxiliarList.next=head; 
        auxiliarList = auxiliarList.next;

        for(int i=1; i < max - rotations; i++)  
            auxiliarList = auxiliarList.next;

        ListNode res = auxiliarList.next;
        auxiliarList.next = null; // ending the cycle
        return res;
        /*
        //first we get the length of list and get the values in an array
        int arr[] = new int[500];
        int max=0;
        while(head!=null)
        {
            arr[max++] = head.val;
            head = head.next;
        }
        if (max == 0)
            return null;
        //we are dividing k to the length to get the real number of movements
        int rotations = k % max;
        //we create a new listnode with values
        
        ListNode aux = new ListNode(0);
        ListNode res = aux;
        int beggining = 0;
        for(int i=0; i<max; i++)
        {
            res.next = new ListNode();
            res = res.next;
            if(i-rotations<0)
                res.val = arr[max+i-rotations];
            else
                res.val = arr[beggining++];
        }
        return aux.next; */
    }
}