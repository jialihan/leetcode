package leeeeeeee.array;

public class NextPermutation {



    public static void main(String[] args)
    {
        int[] test = new int[]{1,2,2,4,2};

        System.out.print("origin is : ");
        for(int i = 0 ;i< test.length; i++)
        {
            System.out.print( test[i]);
        }

        int[] res = nextPermutation(test);
        System.out.println(" ");
        System.out.print("next larger is : ");
        for(int i = 0 ;i< test.length; i++)
        {
            System.out.print( test[i]);
        }


    }
    public static int[] nextPermutation(int[] nums) {

        if(nums == null || nums.length == 0)
            return nums;

        int i = nums.length-2;
        while(i>=0 && nums[i]>= nums[i+1])
        {
            i--;
        }
        // now i is the first smaller than i+1
        if(i>=0)
        {
            int j= nums.length-1;
            while(j>i && nums[j]<=nums[i]) {

                j--;
            }

             int tmp = nums[i];
             nums[i] = nums[j];
            nums[j]= tmp;
            // then reverse [i+1, end];

        }

        // if not found i=-1, reverse
        int p =i+1; int q = nums.length-1;
        while(p<q)
        {
            int tmp = nums[p];
            nums[p] = nums[q];
            nums[q]= tmp;
            p++;
            q--;
        }

        return nums;

    }
}

