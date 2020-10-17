import org.junit.Test;

public class Offer39 {
    public int moreThanHalfNum1(int[] nums) throws IllegalAccessException {
        if(nums == null || nums.length == 0){
            throw new IllegalAccessException();
        }
        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums,start,end);
        while(index != middle){
            if(index > middle){
                end = index - 1;
                index = partition(nums,start,end);
            }
            else{
                start = index + 1;
                index = partition(nums,start,end);
            }
        }
        int res = nums[middle];
        if(!checkRes(nums,res))
            res = 0;
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

    private boolean checkRes(int[] nums, int res){
        int times = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res){
                times++;
            }
        }

        if(times * 2 <= nums.length)
            return false;
        else
            return true;
    }

    public int moreThanHalfNum2(int[] nums) throws IllegalAccessException {
        if(nums == null || nums.length == 0){
            throw new IllegalAccessException();
        }

        int res = nums[0];
        int times = 1;
        for(int i = 0; i < nums.length; i++){
            if(times == 0){
                res = nums[i];
                times = 1;
            }
            else if(nums[i] == res){
                times++;
            }
            else
                times--;
        }

        if(!checkRes(nums,res)){
            res = 0;
        }

        return res;
    }

    @Test
    public void test() throws IllegalAccessException {
        int[] test = {2,3,5,2,2};
        System.out.println(moreThanHalfNum2(test));
    }
}
