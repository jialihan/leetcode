package leeeeeeee.binarysearch;

/**
 * Created by jialihan on 17/6/29.
 */
//I pick a number from 1 to n. You have to guess which number I picked.
//
//        Every time you guess wrong, I'll tell you whether the number is higher or lower.

//You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
//        -1 : My number is lower
//        1 : My number is higher
//        0 : Congrats! You got it!
//        Example:
//        n = 10, I pick 6.
//
//        Return 6.

    //guess to use binary-sort guess
public class GuessNumberHighOrLow {

/*

   The guess API is defined in the parent class GuessGame.
       @param num, your guess
       @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num);
 */

    public int guessNumber(int n) {

        if(guess(n) == 0 )
            return n;
        int low = 1;
        int high = n;

        while(low <= high){
            int mid = low+((high-low)/2);
            int result = guess(mid);
            if(result==0){
                return mid;
            }else if(result==1){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }

    private int guess(int number)
    {
        // provided by others
        int  x=1;
        return x;
    }
}