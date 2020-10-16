import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;

import java.io.IOException;

public class Offer33 {
    public boolean verifySquenceOfBST(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        return verifySquenceOfBST(nums,0,nums.length-1);
    }

    private boolean verifySquenceOfBST(int[] nums, int left, int right){
        int  root = nums[right];

        int i = left;
        for(; i < right; i++){
            if(nums[i] > root){
                break;
            }
        }

        int j = i;
        for(; j < right; j++){
            if(nums[j] < root){
                return false;
            }
        }

        boolean leftRes = true;
        if(i > left){
            leftRes = verifySquenceOfBST(nums, left, i-1);
        }

        boolean rightRes = true;
        if( i < right){
            rightRes = verifySquenceOfBST(nums,i,right-1);
        }

        return leftRes && rightRes;
    }

    @Test
    public void tets(){
        int[] nums = {7,2,3};
        System.out.println(verifySquenceOfBST(nums));

    }
}
