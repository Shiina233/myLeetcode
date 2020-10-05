public class Offer21 {
    public static void reorderOddEven(int[] nums){
        if(nums == null)
            return;
        int p1 = 0;
        int p2 = nums.length - 1;
        while(p1 < p2){
            if(!rule(nums[p1]) && rule(nums[p2])){
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;
            }
            if(rule(nums[p1])){
                p1++;
            }
            if(!rule(nums[p2])){
                p2--;
            }
        }
    }

    private static boolean rule(int num){
        return num % 2 == 1;
    }


    public static void main(String[] args){
        int[] test = {5,2,4,4,7,9,8};
        reorderOddEven(test);
        for(int element : test){
            System.out.println(element);
        }
    }
}
