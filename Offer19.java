import java.util.Scanner;

public class Offer19 {
    public static boolean isMatch(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        return isMatchHelper(t, 0, p, 0);
    }

    private static boolean isMatchHelper(char[] t, int index, char[] p, int pIndex) {
        //匹配完成
        if (index == t.length && pIndex == p.length) {
            return true;
        }
        //未匹配完全
        if (index != t.length && pIndex == p.length) {
            return false;
        }
        //当前字符匹配判断
        boolean matchSuc = index < t.length && (p[pIndex] == t[index] || p[pIndex] == '.');
        if (p.length - pIndex >= 2 && p[pIndex + 1] == '*') {
            //匹配0次或多次
            return isMatchHelper(t, index, p, pIndex + 2) || (matchSuc && isMatchHelper(t, index + 1, p, pIndex));
        }
        return matchSuc && isMatchHelper(t, index + 1, p, pIndex + 1);
    }

    public static void main(String[] args) {
        int[] test = {3,2,3};
        out(3,test);
    }

    /**
     *扔n个骰子，第i个骰子有可能投掷出Xi种等概率的不同的结果，数字从1到Xi。所有骰子的结果的最大值将作为最终结果。求最终结果的期望。
     * @param n 几个骰子
     * @param x 每个骰子可能投出的情况
     */
    public static void out(int n, int[] x){
        int max = 0;
        int allAddition = 1;
        double result = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, x[i]);
            allAddition *= x[i];
        }
        int[] every = new int[max];
        for(int i = 1; i <= max; i++){
            every[i-1] = 1;
            for(int j = 0; j < n; j++){
                if(x[j] > i){
                    every[i-1] *= i;
                }
                else{
                    every[i-1] *= x[j];
                }
            }
            every[i-1] -= Math.pow(i-1,n);
            result = result + (i*((double)every[i-1] / allAddition));
        }
        System.out.println(result);
    }





}
