public class Offer15 {
    public static int numberOfOne(int n){
        int count = 0;
        int flag = 1;
        while(n != 0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
