package median;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestMedian {
    @Test
    public void testFindMedianSortedArrays(){
        Median median = new Median();
        int[] nums1 = {1,3,3,9,7};
        int[] nums2 = {2,8,0,9,38,1};
        double result = median.findMedianSortedArrays(nums1,nums2);
        assertEquals(3.0,result);

        nums1 = new int[]{3,4,5};
        nums2 = new int[]{1,2};
        result = median.findMedianSortedArrays(nums1,nums2);

        assertEquals(3.0,result);

    }
}
