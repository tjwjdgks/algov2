package study.algorithm.leetCode;

import java.util.Arrays;

public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<nums1.length;i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
}
