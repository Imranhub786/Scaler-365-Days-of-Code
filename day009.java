Array Sum |asked in ->PAYTM
  ..........................
  Problem Description
 
 

You are given two numbers represented as integer arrays A and B, where each digit is an element.
 You have to return an array which representing the sum of the two given numbers.

The last element denotes the least significant bit, and the first element denotes the most significant bit.

Note : Array A and Array B can be of different size. ( i.e. length of Array A may not be equal to length of Array B ).



Problem Constraints
1 <= |A|, |B| <= 105
0 <= Ai, Bi <= 9


Input Format
The first argument is an integer array A. The second argument is an integer array B.


Output Format
Return an array denoting the sum of the two numbers.


Example Input
Input 1:
A = [1, 2, 3]
B = [2, 5, 5]
Input 2:

A = [9, 9, 1]
B = [1, 2, 1]


Example Output
Output 1:
[3, 7, 8]
Output 2:

[1, 1, 1, 2]


Example Explanation
Explanation 1:
Simply, add all the digits in their place.
Explanation 2:public class Solution {
    public int[] addArrays(int[] A, int[] B) {
        int maxLength = Math.max(A.length, B.length);
        int[] result = new int[maxLength + 1]; 

        int carry = 0;

        int i = A.length - 1;
        int j = B.length - 1;

        int k = result.length - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += A[i];
                i--;
            }

            if (j >= 0) {
                sum += B[j];
                j--;
            }

            result[k] = sum % 10;
            carry = sum / 10;

            k--;
        }

        if (carry > 0) {
            result[k] = carry;
        }
        if (result[0] == 0) {
            int[] ans = new int[result.length - 1];
            System.arraycopy(result, 1, ans, 0, ans.length);
            return ans;
        }

        return result;
    }
    
}
Time complexity:O(max(N,M))
  Space complexity:O(max(N,M))
  

991 + 121 = 1112
Note that the resultant array size might be larger.
  ......................................................
  
