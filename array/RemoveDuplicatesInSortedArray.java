package leeeeeeee.array;

public class RemoveDuplicatesInSortedArray {



        public static void main(String[] args)
        {
            int[] test = new int[]{1,2,2};
            int cnt = removeDuplicates2(test);
            for(int i = 0 ;i< cnt; i++)
            {
                System.out.print(" " + test[i]);
            }


        }
        // my solution 20.8% defeat
    public static  int removeDuplicates(int[] nums) {

        if(nums == null || nums.length==0)
            return 0;
        int cnt = 0;
        int i = 0;
        int start =0;
        while(i<nums.length)
        {
            cnt++;
            nums[start++] = nums[i];
            if(i<nums.length-1 && nums[i] == nums[i+1])
            {
                while(i<nums.length-1 && nums[i] == nums[i+1])
                {
                    i++;
                }
            }
            i++;
        }

        return cnt;
    }

    // second solution
    public static int removeDuplicates2(int[] nums)
    {
        if(nums == null || nums.length==0)
            return 0;
        int pre = nums[0];
        int start = 1;
        for(int i =1; i<nums.length;i++)
        {
            if(nums[i] == pre)
            {

                continue;
            }
            else
            {
                nums[start++] = nums[i];
                pre=nums[i];
            }
        }
        return start;

    }

    // fast solution -> other's
    public int removeDuplicates3(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;

        int i=0;
        for(int num : nums)
        {
            if(i==0 || num > nums[i-1])
                nums[i++] = num;
        }

        return i;
    }













    }


