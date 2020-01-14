package solution;

public class lessDuration {
    private int[][] matrix = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem = new int[4][4];

    public int minDist(int i, int j) { // 调用minDist(n-1, n-1);
        if (i == 0 && j == 0) return matrix[0][0];
        if (mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if (j-1 >= 0) {
        minLeft = minDist(i, j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i-1 >= 0) {
        minUp = minDist(i-1, j);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

    public static void main(String[] args) {
        lessDuration lessDuration = new lessDuration();
        int min = lessDuration.minDist(lessDuration.n-1, lessDuration.n-1);
        System.out.println(min);
    }
}
