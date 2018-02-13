package leeeeeeee.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {

    //螺旋遍历 array
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     For example,
     Given the following matrix:

     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     You should return [1,2,3,6,9,8,7,4,5].
     */
    public static void main(String[] args)
    {
        SpiralMatrix instance = new SpiralMatrix();
       int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] nums = new int[][]{{2,5,8},{4,0,-1}};
        List<Integer> res = instance.spiralOrder(nums);
        for(int i : res)
        {
            System.out.print(i + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int x =0;
        int y =0;
        while(m>0 && n>0)
        {
            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    res.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    res.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle
            // top
            for(int k=0; k<n-1; k++)
            {
                res.add(matrix[x][y++]);
            }
            // right
            for(int k=0; k<m-1; k++)
            {
                res.add(matrix[x++][y]);
            }
            // buttom
            for(int k=n-1; k>0; k--)
            {
                res.add(matrix[x][y--]);
            }
            //left
            for(int k = m-1; k>0; k--)
            {
                res.add(matrix[x--][y]);
            }
            m = m-2;
            n = n-2;
            x++;
            y++;
        }  // end while

        return res;
    }
}
