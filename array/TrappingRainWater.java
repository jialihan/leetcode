package leeeeeeee.array;

public class TrappingRainWater {

//    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//            For example,
//    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    public static void main(String[] args)
    {
        int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater instance = new TrappingRainWater();
    //    System.out.print("sum is "+ instance.trap2(test));
        System.out.print("sum is "+ instance.trap_1_optimize(test));

        }

    // only compute the difference extra space
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int leftmax =0;
        int rightmax =0;

        int sum =0;
        while(left<=right)
        {
            if(height[left] <= height[right])
            {
                if(height[left] >= leftmax)
                {
                    leftmax = height[left++];
                }
                else
                {
                    sum += leftmax - height[left++];
                }

            }
            else
            {
                if(height[right] >= rightmax)
                {
                    rightmax = height[right--];
                }
                else
                {
                    sum += rightmax - height[right--];
                }
            }
        } // end while
        return sum;
    }

    // compute all space then subtract the everyone
    public int trap2(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        int sum = 0;
        int left = 0;
        int right = height.length-1;
        int cur_level = 0;
        int tmp_level = 0;

        while(left <= right)
        {
            tmp_level = Math.min(height[left],height[right]);

            if(tmp_level> cur_level)
            {
                sum += (right-left+1) * (tmp_level - cur_level);
                cur_level = tmp_level;
            }

            // anyway if tmp_levl < cur level, minus it immediately
            // even if after add the tmp level, still minus the min_value stick
            if(height[left]<height[right])
            {
                sum -= height[left++];
            }
            else
            {
                sum -= height[right--];
            }
        } // end while

        return sum;
    }

    // only compute the difference extra space
    public int trap_1_optimize(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int leftmax =0;
        int rightmax =0;

        int sum =0;
        // rewrite the while loop code, more simpler
        while(left<=right)
        {
            leftmax = Math.max(height[left], leftmax);
            rightmax = Math.max(height[right],rightmax);

            if(leftmax < rightmax)
            {
                sum += leftmax - height[left++];
            }
            else
            {
                sum += rightmax - height[right--];
            }
        } // end while
        return sum;
    }
}
