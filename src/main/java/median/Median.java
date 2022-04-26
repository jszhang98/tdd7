package median;

import tools.Indicator;

public class Median {
    int count = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] totalArray = connnectArrays(nums1,nums2);

        //exchange two ints
        boolean flag = true;
        while(flag) {
            flag = false;
            flag = exchangeElement(totalArray,0);
            flag = exchangeElementBackword(totalArray,0);
        }

        double  theMedian = 0;
        if (totalArray.length%2 ==1 ){
           theMedian = totalArray[(totalArray.length-1)/2];
        }else{
           theMedian = (double)(totalArray[totalArray.length/2] + totalArray[totalArray.length/2-1])/2.0;
        }

        System.out.println("The total times for all loops is " + count);
        return theMedian;
    }

    private int[] connnectArrays(int[] nums1, int[] nums2){

        int[] totalArray = new int[nums1.length+nums2.length];
        for(int i = 0; i< nums1.length+nums2.length;i++){
            count++;
            if (i>=nums1.length){
                totalArray[i] = nums2[i-nums1.length];
            }else{
                totalArray[i]=nums1[i];
            }
        }
        return totalArray;
    }

    private boolean exchangeElement(int[] totalArray ,int offset){
        boolean flag = false;
        Indicator indicator = new Indicator();
        for (int i = offset; i < totalArray.length-1; i ++) {
           int j= 0 ;
            do {
                flag = exchange(totalArray, i+j, i + 1+j);
                indicator.alarm(flag);
                j++;
            }while(flag && i+j+1<totalArray.length);
        }
        return indicator.getStatus();
    }
    private boolean exchange(int[] totalArray,int x, int y){
        int tempValue = 0;
        count++;
        boolean flag = false;
        if (totalArray[x] > totalArray[y]) {
            flag =true;
            tempValue = totalArray[x];
            totalArray[x] = totalArray[y];
            totalArray[y] = tempValue;
        }
        return flag;
    }
    private boolean exchangeElementBackword(int[] totalArray ,int offset){
        boolean flag = false;
        Indicator indicator = new Indicator();
        for (int i = totalArray.length -1 ; i >0; i --) {

            int j= 0 ;
            do {
                //flag = exchange(totalArray, i-j, i - 1-j);
                flag = exchange(totalArray,  i - 1-j,i-j);
                indicator.alarm(flag);
                j++;
            }while(flag && i-j-1>=0);

        }
        return indicator.getStatus();
    }






}
