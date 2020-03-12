package solution;

import java.util.HashSet;

public class LongestDupSubstring {

    public String longestDupSubstring(String S) {
        int lenth = S.length();
        int[] nums = new int[lenth];
        for (int i = 0; i < lenth; i++){
            nums[i] = (int)S.charAt(i) - (int)'a';
        }
        int a = 26;
        long modulus = (long)Math.pow(2, 32);
        int left = 1,  right = lenth;
        while (left != right){
            int L = left + (right - left)/2;
            if (-1 != search(L, modulus, lenth, nums, a)) {left = L + 1;}
            else {right = L;}
        }
        int start = search(left-1, modulus, lenth, nums, a);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    private int search(int L, long modulus, int lenth, int[] nums, int a) {
        long h = 0;
        for (int i = 0; i < L; ++i){
            h = (h*a + nums[i]) % modulus;
        }
        HashSet<Long> hashSet = new HashSet();
        hashSet.add(h);
        long aL = 1;
        for (int i = 1; i <= L; ++i){
            aL = (aL*a) % modulus;
        }
        for (int start = 1; start < lenth - L +1; start ++){
            h = (h*a - nums[start-1]*aL%modulus + modulus) % modulus;
            h = (h + nums[start+L-1])%modulus;
            if (hashSet.contains(h)){
                return  start;
            }
            hashSet.add(h);
        }
        return -1;
    }
}
