#DAY1:Pick from both sides!
  Problem Description
 
 

Given an integer array A of size N.

You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc. you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get

  ............................
   public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int ans = 0;

        // Calculate the sum of the first B elements
        for (int i = 0; i < B; i++) {
            ans += A[i];
        }

        // Initialize variables for sliding window approach
        int temp = ans;
        int left = B - 1;
        int right = n - 1;

        while (left >= 0 && right >= 0) {
            // Add the current elements in the window
            temp += A[right];
            temp -= A[left];

            // Update the maximum sum
            ans = Math.max(ans, temp);

            // Move the window
            left--;
            right--;
        }

        return ans;
        
    }
}
//Time complexity:O(n)
//Space Complexity:O(1)
