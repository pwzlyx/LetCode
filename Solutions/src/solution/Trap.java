package solution;

public class Trap {
    //动态规划解法
    public int trap(int[] height) {
        if (height == null){
            return 0;
        }
        if (height.length == 0){
            return 0;
        }
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int size = height.length;

        leftMax[0] = height[0];
        for (int i = 1; i < size; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        rightMax[size-1] = height[size-1];
        for (int i = size-2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        for (int i = 0; i < size-1; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height){
        if (height == null){
            return 0;
        }
        if (height.length == 0){
            return 0;
        }
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= leftMax){
                    leftMax = height[left];
                    left++;
                }else{
                    ans += leftMax - height[left];
                    left++;
                }
            }else{
                if (height[right] >= rightMax){
                    rightMax = height[right];
                    right--;
                }else{
                    ans +=  rightMax - height[right];
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap2(new int[]{2,0,2}));
    }
}
