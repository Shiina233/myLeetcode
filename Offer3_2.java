public class Offer3_2 {
    private static int countRange(int nums[], int left, int right){
        int count = 0;
        if(nums == null)
            return count;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= left && nums[i] <= right){
                count++;
            }
        }
        return count;
    }

    public static int getDuplication(int[] nums){
        if(nums == null){
            return -1;
        }
        int left = 1;
        int right = nums.length - 1;
        while(right >= left){
            int middle = ((right - left) / 2) + left;
            System.out.println(left+" "+middle+" "+right);
            int count = countRange(nums,left,middle);
            if(left == right){
                if(count > 1){
                    return left;
                }
                else{
                    break;
                }

            }
            if(count > (middle - left + 1)){
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int getDup(int[] nums, int left, int right){
        int middle = (right - left) / 2 + left;
        int count = countRange(nums,left,middle);
        System.out.println(left+" "+middle+" "+right);
        if(left == right && count > 1){
            return left;
        }
        if(left < right){
            if(count > middle - left + 1)
                return getDup(nums, left, middle);
            else
                return getDup(nums,middle+1,right);
        }
        return -1;
    }

    public static void main(String[] args){
        int test1[] = {2,3,5,4,3,2,6,7};
        int test2[] = {2,3,5,4,3,2,6,7};
        System.out.println(getDuplication(test1));
        System.out.println(getDup(test2,1,test2.length-1));
    }
}
