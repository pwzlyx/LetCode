package solution;

import java.util.LinkedList;
import java.util.Queue;

//BFS解法
public class UpdateMatrix {
    private int[][] dirArr = new int[][]{{1,0}, {0, 1}, {-1,0}, {0,-1}};
    public int[][] updateMatrix(int[][] matrix){
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i,j});
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size();i++){
                int[] pArr = queue.poll();
                int c = pArr[0];
                int r = pArr[1];
                for (int [] dir: dirArr
                     ) {
                    int nc = c + dir[0], nr = r + dir[1];
                    if (inArea(matrix, nc, nr) && matrix[nc][nr] == Integer.MAX_VALUE){
                        matrix[nc][nr] = matrix[c][r] + 1;
                        queue.offer(new int[]{nc, nr});
                    }
                }
            }
        }
        return matrix;
    }

    private boolean inArea(int[][] matrix, int nc, int nr) {
        return nc >= 0 && nc < matrix.length && nr >= 0 && nr < matrix[0].length;
    }

    //动态规划解法
    public int[][] updateMatrix2(int[][] matrix){
        int rows = matrix.length;
        if (rows == 0){
            return matrix;
        }
        int cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++){
                res[i][j] = Integer.MAX_VALUE - 10000;
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                    res[i][j] = 0;
                }
                else{
                    if (i > 0){
                        res[i][j] = Math.min(res[i][j], res[i-1][j] + 1);
                    }
                    if (j > 0){
                        res[i][j] = Math.min(res[i][j], res[i][j-1] + 1);
                    }
                }
            }
        }

        for (int i = rows-1; i >= 0; i--){
            for (int j = cols-1; j >= 0 ; j--){
                if (matrix[i][j] == 0){
                    res[i][j] = 0;
                }
                else{
                    if (i < rows-1){
                        res[i][j] = Math.min(res[i][j], res[i+1][j] + 1);
                    }
                    if (j < cols-1){
                        res[i][j] = Math.min(res[i][j], res[i][j+1] + 1);
                    }
                }
            }
        }
        return res;
    }
}
