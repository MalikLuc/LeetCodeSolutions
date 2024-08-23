public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int overflow = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(n1 != null || n2 != null){
            int x = (n1 != null) ? n1.val : 0;
            int y = (n2 != null) ? n2.val : 0;
            int sum = x + y + overflow;
            // extract an element from each list
            // add the elements and and add the overflow of the previous adddition
            overflow = overflow = sum / 10;
            // add the rersult to the result list and subtract the overflow
            temp.next = new ListNode(sum % 10);
            // update the temp variables
            if (n1!=null) n1 = n1.next;
            if (n2!=null) n2 = n2.next;
            temp = temp.next;
        }
        if(overflow > 0) temp.next = new ListNode(overflow);
        return result.next;
    }
}
}
