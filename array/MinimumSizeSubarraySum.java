package leeeeeeee.array;

public class MinimumSizeSubarraySum {

    /**
     * 么我们先来看O(n)的解法，我们需要定义两个指针left和right，分别记录子数组的左右的边界位置，
     * 然后我们让right向右移，直到子数组和大于等于给定值或者right达到数组末尾，此时我们更新最短距离，
     * 并且将left像右移一位，然后再sum中减去移去的值，然后重复上面的步骤，直到right到达末尾，
     * 且left到达临界位置，即要么到达边界，要么再往右移动，和就会小于给定值。代码如下：
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int left = 0;
        int right =0;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length)
        {
            while( right<nums.length && sum<s)
            {
                sum += nums[right++];
            }
            while(left <= right && sum>=s)
            {
                minlen = Math.min(minlen, right-left); // right = last valid pos + 1
                sum -= nums[left++];
            }
        }

        return minlen == Integer.MAX_VALUE ? 0 : minlen;

    }

    //method2
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length; i++)
        {
            sum += nums[i];
            while(start <= i && sum >= s)
            {
                minlen = Math.min(minlen,i-start+1);
                sum -= nums[start++];
            }
        }

        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
