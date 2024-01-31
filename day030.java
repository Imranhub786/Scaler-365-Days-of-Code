Palindrome Integer
...................................
Problem Description
 
 

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.



Problem Constraints
INT_MIN <= A <= INT_MAX


Input Format
The first argument is an integer A.


Output Format
Return 1 if A is a Palindrome Integer else return 0.


Example Input
Input 1:
A = 12121
Input 2:
A = 123


Example Output
Output 1:
1
Output 2:
0


Example Explanation
Explanation 1:
 12121 when reversed will be 12121, and 12121 = 12121, hence a palindrome number.

Explanation 2:
 123 when reversed will be 321, and 123 != 321, hence not a palindrome number
.................................................................................................
public class Solution {
    public int isPalindrome(int A) {
        int originalA = A; 
        int rem = 0;
        while (A > 0) {
            int digit = A % 10;
            rem = rem * 10 + digit;
            A /= 10;
        }
        if (rem == originalA) { 
            return 1;
        } else {
            return 0;
        }
    }
}
