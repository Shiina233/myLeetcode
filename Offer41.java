
import java.util.Comparator;
import java.util.PriorityQueue;

public class
Offer41 {
    Comparator comparator;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(2, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private PriorityQueue maxHeap = new PriorityQueue<>();

    public void insert(int num){
        if(((maxHeap.size() + minHeap.size()) & 1) == 0){
            if(maxHeap.size() > 0 && num < (int)maxHeap.peek())
            {
                maxHeap.offer(num);
                num = (int) maxHeap.poll();
            }

            minHeap.offer(num);
        }
        else{
            if(minHeap.size() > 0 && num > (int) minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }

            maxHeap.offer(num);
        }
    }

    public int getMedian() throws IllegalAccessException {
        int size = minHeap.size() + maxHeap.size();
        if(size == 0){
            throw new IllegalAccessException("no numbers");
        }

        int median = 0;
        if((size & 1) == 1)
            median = minHeap.peek();
        else{
            median = ((Integer) minHeap.peek() + (Integer)maxHeap.peek()) / 2;
        }

        return median;
    }
}
