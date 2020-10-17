import org.junit.Test;

public class Offer43 {
    public int numberOf1(int n){
        String str = String.valueOf(n);
        char[] ctr = str.toCharArray();
        return 0;
    }

    public int numberOf1Core(int n){
        String str = String.valueOf(n);
        char[] ctr = str.toCharArray();
        int first = ctr[0] - '0';
        if(ctr.length == 1 && first == 0){
            return 0;
        }
        if(ctr.length == 1 && first > 0){
            return 1;
        }
        int numFirstDigit = 0;
        if(first > 1){
            numFirstDigit = (int) Math.pow(10,ctr.length - 1);
        }
        else if(first == 1){
            numFirstDigit = n - (int) Math.pow(10,ctr.length - 1) + 1;
        }

        int numOtherDigits = first * (ctr.length - 1) * (int) Math.pow(10,ctr.length - 2);
        int numRecursive = numberOf1Core(n - first * (int) Math.pow(10,ctr.length - 1));
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    @Test
    public void test(){
        System.out.println(numberOf1Core(21));
    }
}
