/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode aux = new ListNode(0);
        ListNode res = aux;
        
        while(list1 != null || list2 != null)
        {
            if(list1 == null || list2 != null && list1.val > list2.val)
            {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            else
            {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            res = res.next;
        }
        return aux.next; 
    }       
    
    /* 
     if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode aux = new ListNode(0);
        ListNode res = aux;

        boolean list1Done = false;
        boolean list2Done = false;
        
        while(!list1Done || !list2Done)
        {
            if(list1Done)
            {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
                res = res.next;
                if (list2 == null)
                    list2Done = true;
            }
            else if(list2Done)
            {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
                res = res.next;
                if (list1 == null)
                    list1Done = true;
            }
            else{
                if(list1.val > list2.val)
                {
                    res.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                else
                {
                    res.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
                res = res.next;

                if(list1 == null)
                    list1Done = true;
                if (list2 == null)
                    list2Done = true;
            }

        }
        return aux.next;        
    
    
    }*/
}