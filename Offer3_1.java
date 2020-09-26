public class Offer3_1 {
    public static int duplicate(int[] nums){
        int dup = -1;
        int n;
        if(nums == null){
            return dup;
        }
        else{
            n = nums.length;
        }
        for(int i = 0; i < n; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    dup = nums[i];
                    return dup;
                }
                else {
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }
        return dup;
    }

    public static void main(String[] args){
        int test1[] = {2,3,4,0,1,5,6};
        int test2[] = {2,3,1,0,2,5,3};
        System.out.println(duplicate(test1));
        System.out.println(duplicate(test2));
    }

}
