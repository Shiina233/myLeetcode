public class Offer40 {
    public int[] getLeastNumbers1(int[] nums,int k) throws IllegalAccessException {
        if(nums == null || nums.length == 0){
            throw new IllegalAccessException();
        }
        if(k <=0 || k > nums.length){
            throw new IllegalAccessException();
        }
        int[] res = new int[k];
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums,start,end);

        while(index != k - 1){
            if(index > k - 1){
                end = index - 1;
                partition(nums,start,end);
            }
            else{
                start = index + 1;
                partition(nums,start,end);
            }
        }

        for(int i = 0; i < k; i++){
            res[i] = nums[i];
        }
        return res;
    }

    private int partition(int[] nums, int start, int end) throws IllegalAccessException {
        if(nums == null || nums.length == 0){
            throw new IllegalAccessException();
        }
        int index = (int) Math.random()*(end - start+1) + start;
        int tmp = nums[end];
        nums[end] = nums[index];
        nums[index] = tmp;

        int small = start - 1;
        for(index = start; index < end; index++){
            if(nums[index] < nums[end]){
                small++;
                if(small != index){
                    tmp = nums[index];
                    nums[index] = nums[small];
                    nums[small] = tmp;
                }
            }
        }
        small++;
        tmp = nums[end];
        nums[end] = nums[small];
        nums[small] = tmp;
        return small;
    }
}
