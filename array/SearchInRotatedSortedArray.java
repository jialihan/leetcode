package leeeeeeee.array;

public class SearchInRotatedSortedArray {

    /**
     *  My first solution
     *  Find the pivot first, then search part of it
     *
     */
    public int search(int[] nums, int target) {

        if(nums == null || nums.length==0)
            return -1;

        int res = -1;
        int pivot = -1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]<nums[i])
            {
                pivot = i;
            }
        }
        // if has pivot
        if(pivot < 0)
            return binarySearchRange(0,nums.length-1,nums,target);
        else
        {
            if(target>nums[nums.length-1])
            {
                res = binarySearchRange(0,pivot,nums,target);
            }
            else
            {
                res = binarySearchRange(pivot+1, nums.length-1,nums,target);
            }
            return res;
        }

    }

    public int binarySearchRange(int l, int r, int[] nums,int target)
    {
        if(r<l)
        {
            return -1;
        }

        int mid = (l+r)/2;
        if(target == nums[mid])
        {
            return mid;
        }
        else if(target >  nums[mid])
        {
            return binarySearchRange(mid+1,r,nums,target);
        }
        else
        {
            return binarySearchRange(l,mid-1,nums,target);
        }
    }


    /**
     * Better solution
     *
     * Pivot including the if/else block
     *
     */
    public int search2(int[] nums, int target) {

        if(nums == null || nums.length==0)
            return -1;
        int res = -1;

        res = binarySearch2(0, nums.length-1, nums,target);
        return res;

    }

    public int binarySearch2(int l, int r, int[] nums,int target)
    {
        if(r<l)
        {
            return -1;
        }

        int mid = (l+r)/2;
        if(target == nums[mid])
        {
            return mid;
        }

        if( nums[mid] < nums[r])
        {
            if( target> nums[mid] && target<= nums[r])
            {
                return binarySearch2(mid+1,r,nums,target);
            }
            else
            {
                return binarySearch2(l,mid-1,nums,target);
            }

        }
        else
        {
            // nums[mid]>= nums[r]
            if(target>= nums[l] && target< nums[mid])
            {
                return binarySearch2(l,mid-1,nums,target);
            }
            else
            {
                return binarySearch2(mid+1,r,nums,target);
            }
        }
    }


    /**
     * Optimize the recursive call
     *
     */
    public int search3(int[] nums, int target) {

        if(nums == null || nums.length==0)
            return -1;


        int l = 0;
        int r = nums.length-1;
        while(l<=r)
        {

            int mid = (l+r)/2;
            if(nums[mid] == target)
            {
                return mid;
            }

            if(nums[mid]< nums[r])
            {
                if(nums[target]<=nums[r] && nums[target]>nums[mid])
                {
                    l = mid+1;
                }
                else
                {
                    r = mid-1;
                }
            }
            else
            {
                if(nums[target]>= nums[l] && nums[target]<nums[mid])
                {
                    r = mid-1;
                }
                else
                {  l = mid+1;}
            }

        } // end while
        return -1;

    }

}
