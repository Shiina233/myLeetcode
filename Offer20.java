public class Offer20 {
    public static boolean isNum(String str) {
        if (str == null || str == "") {
            return false;
        }
        char[] ctr = str.toCharArray();
        int index = 0;
        int[] p = new int[1];
        p[0] = 0;
        boolean numeric = scanInt(ctr, p);
        if (ctr[p[0]] == '.') {
            p[0]++;
            numeric = scanUnsignedInt(ctr, p) || numeric;
        }
        if (ctr[p[0]] == 'e' || ctr[p[0]] == 'E') {
            p[0]++;
            numeric = numeric && scanInt(ctr, p);
        }
        return numeric && p[0] == ctr.length;
    }

    private static boolean scanUnsignedInt(char[] ctr, int[] index) {
        int before = index[0];
        while (index[0] < ctr.length && ctr[index[0]] >= '0' && ctr[index[0]] <= '9') {
            index[0]++;
        }
        return index[0] > before;
    }

    private static boolean scanInt(char[] ctr, int[] index) {
        if (ctr[index[0]] == '+' || ctr[index[0]] == '-') {
            index[0]++;
        }
        return scanUnsignedInt(ctr, index);
    }
}
