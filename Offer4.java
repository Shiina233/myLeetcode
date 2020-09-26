public class Offer4 {
    public static boolean find(int[][] nums, int row, int column,int number){
        if(row < 0 || column < 0 || row > nums.length-1 || column > nums[0].length-1){
            return false;
        }
        if(nums[row][column] == number){
            return true;
        }
        else if(nums[row][column] > number){
            return find(nums,row,column - 1,number);
        }
        else{
            return find(nums,row + 1,column,number);
        }
    }

    public static boolean find(int[][] nums, int number){
        if(nums == null){
            return false;
        }
        return find(nums,0,nums[0].length-1,number);
    }

    public static void main(String[] args){
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(a,1));
    }
}
