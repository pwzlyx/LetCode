package solution;

import java.util.LinkedList;
import java.util.Queue;

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
}
