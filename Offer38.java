import org.junit.Test;

public class Offer38 {
    public void permutation(String str) {
        char[] ctr = str.toCharArray();
        permutation(ctr, 0);
    }

    private void permutation(char[] ctr, int left) {
        if (left == ctr.length)
            printCharArray(ctr);
        else
            for (int i = left; i < ctr.length; i++) {
                char tmp = ctr[left];
                ctr[left] = ctr[i];
                ctr[i] = tmp;

                permutation(ctr, left + 1);

                tmp = ctr[left];
                ctr[left] = ctr[i];
                ctr[i] = tmp;
            }
    }

    private void printCharArray(char[] ctr) {
        for (int i = 0; i < ctr.length; i++) {
            System.out.print(ctr[i]);
        }
        System.out.println("");
    }

    @Test
    public void test() {
        permutation("abc");
    }
}
