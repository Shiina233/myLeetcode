import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer9 {
    private Stack stack1;
    private Stack stack2;
    public Offer9(){
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int x){
        stack1.push(x);
    }

    public int deleteHead(){
        if(stack2.size() <= 0){
            while(stack1.size() > 0){
                int tmp = (int) stack1.pop();
                stack2.push(tmp);
            }
        }

        try{
            if(stack2.size() == 0){
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        int head = (int) stack2.pop();
        return head;
    }

}
