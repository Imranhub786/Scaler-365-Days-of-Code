#Largest Number
  ************************************
  Problem Description
 
 

Given a list of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.


Problem Constraints
1 <= |A| <= 105
0 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return a string representing the largest number formed


Example Input
A = [3, 30, 34, 5, 9]


Example Output
9534330


Example Explanation
Largest possible number that can be formed is 9534330
  .................................................................
  public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        int n = A.length;
        String[] s = new String[n]; 
        for (int i = 0; i < n; i++)
            s[i] = String.valueOf(A[i]);
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder str = new StringBuilder();
        for (String sb : s) 
            str.append(sb);
        String ans = str.toString();
        return ans.startsWith("0") ? "0" : ans;
    }
}
#Time complexity:O(nlogn)
  #Space complexity:O(n)
