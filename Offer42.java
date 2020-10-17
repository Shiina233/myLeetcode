public class Offer42 {
    public int findGreatestNums(int[] nums) throws IllegalAccessException {
        if(nums == null || nums.length == 0){
            throw new IllegalAccessException();
        }

        int current = 0;
        int greatest = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(current <= 0){
                current = nums[i];
            }
            else{
                current += nums[i];
            }

            if(current > greatest){
                greatest = current;
            }
        }

        return greatest;
    }
}
