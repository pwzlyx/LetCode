package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums) {
        List res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2;i++){
            int leftPointer = i+1;
            int rightPointer = nums.length - 1;
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i-1] == nums[i]) {continue;}
            while (leftPointer < rightPointer){
                int sum =nums[i] + nums[leftPointer] + nums[rightPointer];
                if (sum == 0){
                   res.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer+1]){leftPointer++;}
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer-1]){rightPointer--;}
                    leftPointer++;
                    rightPointer--;
                }else if (sum < 0){
                    leftPointer++;
                }else {
                    rightPointer--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List list = threeSum.threeSum(nums);
        for (Object lists:list
             ) {
            System.out.println(list.toString());
        }
    }
}
