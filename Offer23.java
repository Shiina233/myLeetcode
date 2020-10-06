public class Offer23 {
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

    public static ListNode meetingNode(ListNode head){
        if(head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(true){
            if(p2 == null ||p2.next == null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                break;
            }
        }
        return p2;
    }

    public static ListNode entryNodeOfLoop(ListNode head){
        ListNode meetingNode = meetingNode(head);
        if(meetingNode == null){
            return null;
        }
        int nodesLoop = 1;
        ListNode p1 = meetingNode;
        while(true){
            if(p1.next == meetingNode){
                break;
            }
            p1 = p1.next;
            nodesLoop++;
        }
        p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < nodesLoop; i++){
            p2 = p2.next;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p3;
        ListNode p = entryNodeOfLoop(p1);
        if(p == null){
            System.out.println("null");
        }
        System.out.println(p.val);
    }
}
