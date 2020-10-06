public class Offer25 {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(){
            this(0);
        }

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public static ListNode merge(ListNode p1, ListNode p2) {
        if(p1 == null){
            return p2;
        }
        else if(p2 == null){
            return p1;
        }
        ListNode mergeNode = null;
        if(p1.val < p2.val){
            mergeNode = p1;
            mergeNode.next = merge(p1.next,p2);
        }
        else{
            mergeNode = p2;
            mergeNode.next = merge(p1,p2.next);
        }
        return mergeNode;
    }

}
