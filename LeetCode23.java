import org.junit.Test;

public class LeetCode23 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        return mergeKList1(lists,0, lists.length-1);

    }

    private static ListNode mergeKList1(ListNode[] lists, int left, int right){
        if(right - left == 0){
            return lists[right];
        }
        if(right - left == 1){
            return mergeTwo(lists[left], lists[right]);
        }
        int mid = ((right - left) >> 1) + left;
        return mergeTwo(mergeKList1(lists,left,mid),mergeKList1(lists,mid+1,right));
    }

    private static ListNode mergeTwo(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeNode = null;
        if(list1.val < list2.val){
            mergeNode = list1;
            mergeNode.next = mergeTwo(list1.next,list2);
        }
        else{
            mergeNode = list2;
            mergeNode.next = mergeTwo(list1,list2.next);
        }
        return mergeNode;
    }



    public ListNode[] generate(int k, int m) {
        int num = k * m;
        ListNode[] test = new ListNode[k];
        for (int i = 0; i < k; i++) {
            test[i] = new ListNode(0);
        }
        ListNode[] p = new ListNode[k];
        for(int i = 0; i < k; i++){
            p[i] = test[i];
        }
        for (int j = 0; j < num; j++) {
            int h = j % k;
            p[h].next = new ListNode(j);
            p[h] = p[h].next;
        }
        return test;
    }

    public static void printLists(ListNode[] l){
        for(int i = 0; i < l.length; i++){
            ListNode p = l[i];
            while(p.next!=null){
                System.out.print(p.val+"  ");
                p = p.next;
            }
            System.out.println("");
        }
    }
    @Test
    public void test(){
        var test = new LeetCode23();
        ListNode[] t = test.generate(2,10);
        ListNode[] p = new ListNode[0];
        printLists(t);
        System.out.println("");
        ListNode res = mergeKLists(t);
        ListNode[] hh = new ListNode[1];
        hh[0] = res;
        printLists(hh);
    }


}
