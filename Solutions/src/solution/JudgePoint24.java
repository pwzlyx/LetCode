package solution;

import java.util.ArrayList;

public class JudgePoint24 {
    public boolean judgePoint24(int[] nums){
        ArrayList<Double> A = new ArrayList<>();
        for (int v: nums
             ) {
           A.add((double)v);
        }
        return slove(A);
    }

    private boolean slove(ArrayList<Double> a) {
        if (a.size() == 0) {return false;}
        if (a.size() == 1) {return (a.get(0) - 24 <= 1e-6);}
        for (int i=0; i < a.size(); i++){
            for (int j=0; j < a.size(); j++){
                if (i != j){
                    ArrayList<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < a.size();k++){
                        if (k != i && k != j){
                            nums2.add(a.get(k));
                        }
                    }
                    for (int k =0; k < 4; k++){
                        if (k < 2 && j > i) {continue;}
                        if (k == 0) {nums2.add(a.get(i) + a.get(j));}
                        if (k == 1) {nums2.add(a.get(i) * a.get(j));}
                        if (k == 2) {nums2.add(a.get(i) - a.get(j));}
                        if (k == 3){
                            if (nums2.get(j) != 0){nums2.add(a.get(i) / a.get(j));}
                        }else {
                            continue;
                        }
                    }
                    if (slove(nums2)) {return true;}
                    nums2.remove(nums2.size()-1);
                }
            }
        }
        return false;
    }
}
