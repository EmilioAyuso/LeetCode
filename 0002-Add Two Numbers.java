/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aux = new ListNode(0);
        ListNode res = aux;
        int add1 = 0;
        int sum;
        while(l1 != null || l2 != null)
        {
            if(l1 != null && l2 != null)
                sum = l1.val + l2.val + add1; //both list 
            else if(l2 == null)
                sum = l1.val + add1; // just list1
            else
                sum = l2.val + add1; // just list 2

            add1 = sum/10; //when sum>9   
            res.next = new ListNode(sum%10);
            res = res.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;    
        }
        if (add1 == 1)
            res.next = new ListNode(1);//if last sum is > 9
        return aux.next;
    }
}