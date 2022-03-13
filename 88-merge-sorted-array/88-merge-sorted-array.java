class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex1 = m - 1;
        int lastIndex2 = n - 1;
        int totalIndex = m + n - 1;
        
        while(lastIndex1 >= 0 && lastIndex2 >= 0) {
            if(nums1[lastIndex1] > nums2[lastIndex2]) {
                nums1[totalIndex] = nums1[lastIndex1];
                lastIndex1--;
                totalIndex--;
            } else {
                nums1[totalIndex] = nums2[lastIndex2];
                lastIndex2--;
                totalIndex--;
            }
        }
        while(lastIndex1 >= 0) {
            nums1[totalIndex] = nums1[lastIndex1];
            lastIndex1--;
            totalIndex--;
        }
        while(lastIndex2 >= 0) {
            nums1[totalIndex] = nums2[lastIndex2];
            lastIndex2--;
            totalIndex--;
        }
    }
}