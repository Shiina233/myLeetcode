public class Offer18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode head, ListNode p){
        if(p.next != null){
            p.val = p.next.val;
            p.next = p.next.next;
        }
        else{
            if(head == p){

            }
            else{
                ListNode pNode = head;
                while(pNode.next != p){
                    pNode = pNode.next;
                }
                pNode.next = null;
            }
        }
    }
}
