Segregate 0s and 1s in an array

  .......................................
  Problem Description
 
 


You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once. 



Problem Constraints
1<=|A|<=1e6


Input Format
First argument is array of integers consisting of 0's and 1's only.


Output Format
Return a sorted array.


Example Input
Input 1:
a=[0 1 0]
Input 2:

A=[1 1 0 ]


Example Output
Ouput 1:
[0 0 1]
Ouput 2:

[0 1 1]


Example Explanation
Explanation 1:
 above is sorted array.
Explanation 2:

sort the array.
  ....................................
  public class Solution {
    public int[] solve(int[] A) {
        int size=A.length;
        int left = 0, right = size - 1; 
  
        while (left < right)  
        { 
            while (A[left] == 0 && left < right) 
               left++; 

            while (A[right] == 1 && left < right) 
                right--; 

            if (left < right)  
            { 
                A[left] = 0; 
                A[right] = 1; 
                left++; 
                right--; 
            } 
        } 
        return A;
    } 
        
    
}
