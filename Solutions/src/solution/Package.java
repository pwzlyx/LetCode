package solution;

public class Package {

    private int[] weight = {2,2,4,6,3};
    private int[] value = {3,4,8,9,6};
    private int bigV = 9;

    public void packageZero(){
        int[][] states = new int[weight.length][10];
        for (int i = 0; i < weight.length; i++){
            for (int j = 0; j <= bigV; j++){
                states[i][j] = 0;
            }
        }
        states[0][weight[0]] = value[0];
        for (int i = 1; i < weight.length; i++ ){
            for (int j = 0; j < 9; j++){
                if (j < weight[i-1]){
                    states[i][j] = states[i -1][j];
                }
                else {
                    states[i][j] = Math.max(states[i-1][j], states[i-1][j-weight[i-1]]+ value[i-1]);
                }
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j< 9; j++){
                System.out.println(states[i][j]);
            }
        }
    }

    public static void main(String[] args){
        Package packages = new Package();
        packages.packageZero();
    }

}
