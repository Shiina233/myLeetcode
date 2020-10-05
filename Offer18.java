public class Offer18 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @param head 传入的是头节点，不是第一个节点，传入第一个节点没法删除其本身
     * @param p 待删除节点
     */
    public void deleteNode(ListNode head, ListNode p){
        if(p.next != null){
            p.val = p.next.val;
            p.next = p.next.next;
        }
        else{
            if(head == p){
                head.next = null;
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

    /**
     * 删除重复节点
     * @param head 首节点，即第一个节点
     */
    public static void deleteDuplication(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode pre = null;
        ListNode pNode = head;
        while(pNode.next != null){
            if(pNode.next.val == pNode.val){
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }
    }

    public static void main(String[] args){
        var p0 = new ListNode(1);
        var p1 = new ListNode(2);
        var p2 = new ListNode(3);
        var p3 = new ListNode(4);
        var p4 = new ListNode(5);
        var p5 = new ListNode(6);
        p0.next=p1;
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        deleteDuplication(p0);
        ListNode tmp = p0;
        while(tmp != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
