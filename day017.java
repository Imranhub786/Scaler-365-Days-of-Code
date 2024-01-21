/*Pascal Triangle
******************************************************
Problem Description
 
 

Given an integer A, equal to numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from the previous row R - 1.



Problem Constraints
0 <= A <= 25


Input Format
The first argument is an integer A, equal to the numRows.


Output Format
Return an array of array of integers, equal to pascal triangle.


Example Input
A = 5


Example Output
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
*/
public class Solution {
    public int[][] solve(int A) {
         int[][] result = new int[A][];
        
        for (int i = 0; i < A; i++) {
            result[i] = new int[i + 1];
            result[i][0] = 1;
            result[i][i] = 1;
            
            for (int j = 1; j < i; j++) {
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }
        
        return result;
    }
}

