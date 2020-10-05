public class Exercise {
    /**
     * 现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。
     * 并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
     * 考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？
     * @param n 学生数量
     * @param m 题目数量
     * @param answers 学生答案
     * @param score 每道题分数
     * @return 班级最多可能得到的分
     */
    public static int exam(int n, int m, String[] answers, int[] score){
        //n = answers.length;
        //m = score.length;
        int maxScore = 0;
        for(int i = 0; i < m; i++){
            int[] choiceNum = new int[5];
            for(int j = 0; j < n; j++){
                char tmp = answers[j].charAt(i);
                if(tmp == 'A')
                    choiceNum[0]++;
                else if(tmp == 'B')
                    choiceNum[1]++;
                else if(tmp == 'C')
                    choiceNum[2]++;
                else if(tmp == 'D')
                    choiceNum[3]++;
                else
                    choiceNum[4]++;
            }
            int max = 0;
            for(int j = 0; j < 5; j++){
                max = Math.max(max, choiceNum[j]);
            }
            maxScore += (max * score[i]);
        }
        return maxScore;
    }

    public static void main(String[] args){
        String[] answers = {"ABCD","ABCE"};
        int[] score = {1,2,3,4};
        System.out.println(exam(2,4,answers,score));
    }
}
