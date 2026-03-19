class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= total / 2; k++) {
            prev = curr;

            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }

        if (total % 2 == 1) {
            return curr;
        }

        return (prev + curr) / 2.0;
    }
}