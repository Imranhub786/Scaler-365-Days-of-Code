Maximum Consecutive Gap
......................................
Problem Description
 
 

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.
You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Try to solve it in linear time/space



Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return an integer representing maximum difference between the successive elements in array A.


Example Input
A = [1, 10, 5]


Example Output
5


Example Explanation
The maximum difference is between 5 and 10, which is 5.
...................................................................................................................
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
         if (A.length < 2) {
            return 0;
        }
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);

        int max = 0;
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i + 1] - B[i] > max) {
                max = B[i + 1] - B[i];
            }
        }

        return max;
    }
}
