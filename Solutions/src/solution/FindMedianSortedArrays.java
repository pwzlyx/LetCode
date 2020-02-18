package solution;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        if (m > n){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int imin = 0, imax = m, halfLen = (m+n+1)/2;
        while (imin <= imax){
            int i = (imin + imax)/2;
            int j = halfLen - i;
            if (i < imax && nums2[j-1] > nums1[i]){
                imin = i+1;
            }else if(i > imin && nums2[j] < nums1[i-1]){
                imax = i-1;
            }else{
                int leftMax = 0;
                if (i==0){
                    leftMax = nums2[j-1];
                }else if (j == 0){
                    leftMax = nums1[i-1];
                }else{
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m+n)%2 == 1){return leftMax;}

                int minRight = 0;
                if (i == m){ minRight = nums2[j];}
                else if (j == n){minRight = nums1[i];}
                else{ minRight = Math.min(nums2[j], nums1[i]);}

                return (leftMax + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
