package leeeeeeee.bitManipulation;

/**
 * Created by jialihan on 17/6/1.
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {

        int[] count = new int[32];
        int res = 0;

        for(int i = 0; i< 32; i++)
        {
            for(int num: nums)
            {
                if(((num >> i) & 1) == 1)
                    count[i]++;
            }

            res |= (count[i] % 3) << i;
        }
        return res;

    }
}