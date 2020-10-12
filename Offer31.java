import org.junit.Test;

import java.util.Stack;

public class Offer31 {
    public boolean isPopOrder(int[] pPush, int[] pPop){
        Stack stack = new Stack();
        int p1 = 0;
        int p2 = 0;

        if(pPush != null && pPop != null && pPush.length > 0 && pPop.length > 0){
            while(p2 < pPop.length){
                while(stack.isEmpty() || (int) stack.peek() != pPop[p2]){
                    if(p1 == pPush.length)
                        break;
                    stack.push(pPush[p1]);
                    p1++;
                }

                if((int)stack.peek() != pPop[p2]){
                    break;
                }
                stack.pop();
                p2++;
            }

            if(stack.isEmpty() && p2 == pPop.length){
                return true;
            }
        }
        return false;

    }

    @Test
    public void test(){
        int[] test1 = {1,2,3,4,5};
        int[] test2 = {4,5,3,2,1};
        System.out.println(isPopOrder(test1,test2));
    }
}
