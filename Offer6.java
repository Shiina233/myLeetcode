import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Offer6 {
    public static void printListRev(LinkedList a){
        Stack s = new Stack();
        Iterator itr = a.iterator();
        while(itr.hasNext()){
            s.push(itr.next());
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    private static void printListRev2(Iterator itr){
        if(itr.hasNext()){
            int a = (int) itr.next();
            printListRev2(itr);
            System.out.println(a);
        }
    }
    public static void main(String[] args){
        LinkedList a = new LinkedList();
        a.add(1);
        a.add(2);
        a.add(3);
        Iterator itr = a.iterator();
        printListRev(a);
        printListRev2(itr);
    }
}
