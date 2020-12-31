class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0)
            System.arraycopy(nums2, 0, nums1, 0,n);
        if(nums2 == null || nums2.length == 0)
            return;
        //p是nums1的尾部指针，表示下一个元素放置的位置
        //p1是nums1的实际尾部，表示nums1未放置的最后一个元素
        //p2是nums2的尾部，表示nums2未放置的最后一个元素
        int p1=m-1,p2=n-1,p=m+n-1;
        //有一个指针走完就停止
        while(p1>=0 && p2 >= 0){
            //谁大就放谁
            if(nums2[p2]>=nums1[p1]){
                nums1[p--] = nums2[p2--];
            }
            else{
                nums1[p--] = nums1[p1--];
            }
        }
        //nums2剩下的元素放到nums1之前
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
