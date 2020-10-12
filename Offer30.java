import java.util.Stack;

public class Offer30 {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            if (x < (int) stack2.peek()) {
                stack2.push(x);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            int num = (int) stack1.pop();
            stack2.pop();
            return num;
        } else
            throw new NullPointerException();
    }

    public int min() {
        if (!stack1.isEmpty()) {
            return (int) stack2.peek();
        } else
            throw new NullPointerException();
    }


}
