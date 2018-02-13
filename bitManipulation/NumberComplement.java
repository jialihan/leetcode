package leeeeeeee.bitManipulation;

/**
 * Created by jialihan on 17/1/21.
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 */
public class NumberComplement {
    /*
    //explain

    According to the problem, the result is

The flipped version of the original input but
Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
For example input = 5 (the binary representation is 101), the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3). Then we need to flip 3 bits from RIGHTMOST and the answer is 010
To achieve above algorithm, we need to do 3 steps:

Create a bit mask which has N bits of 1 from RIGHTMOST. In above example, the mask is 111. And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, left shift one, and then minus one. Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, you will be able to use it later.
Negate the whole input number.
Bit AND numbers in step 1 and 2.
     */
    public class Solution {
        public int findComplement(int num) {
            return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        }
    }
}

