Maximum Area of Triangle!
  Problem Description

Given a character matrix of size N x M in the form of a string array A of size N where A[i] denotes ith row.

Each character in the matrix consists any one of the following three characters {'r', 'g', 'b'} where 'r' denotes red color similarly 'g' denotes green color and 'b' denotes blue color.

You have to find the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

NOTE:

If the area comes out to be a real number than return the ceil of that number.


Problem Constraints
2 <= N, M <= 103

A[i][j] = 'r' or A[i][j] = 'g' or A[i][j] = 'b'



Input Format
First and only argument is an string array A of size N denoting the 2D character matrix.



Output Format
Return a single integer denoting the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

If the area comes out to be a real number than return the ceil of that number.



Example Input
Input 1:

 A = ["rrrrr", "rrrrg", "rrrrr", "bbbbb"]
Input 2:

 A = ["rrr", "rrr", "rrr", "rrr"]


Example Output
Output 1:

 10
Output 2:

 0


Example Explanation
Explanation 1:

 The maximum area of triangle is 10.
 Triangle coordinates are (0,0) containing r, (1,4) containing g, (3,0) containing b.
  Explanation 2:

 All cells have same color so no triangle possible so we will return 0
  .....................................................................
public class Solution {
    public int solve(String[] A) {
        // Assuming A is an array of strings representing the colors of the flags
        int[] minCol = new int[3]; // To store the minimum column index for each color
        int[] maxCol = new int[3]; // To store the maximum column index for each color
        int[][] colMin = new int[3][A[0].length()]; // To store the minimum row index for each color and column
        int[][] colMax = new int[3][A[0].length()]; // To store the maximum row index for each color and column
        int cols = A[0].length(); // To store the number of columns
        // Initialize the arrays with extreme values
        for (int i = 0; i < 3; i++) {
            minCol[i] = Integer.MAX_VALUE;
            maxCol[i] = Integer.MIN_VALUE;
            for (int j = 0; j < cols; j++) {
                colMin[i][j] = Integer.MAX_VALUE;
                colMax[i][j] = Integer.MIN_VALUE;
            }
        }
        // Loop through the array of strings and update the arrays
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < cols; j++) {
                int val = retCol(A[i].charAt(j)); // Get the color value for the current character
                minCol[val] = Math.min(minCol[val], j); // Update the minimum column index for the color
                maxCol[val] = Math.max(maxCol[val], j); // Update the maximum column index for the color
                colMin[val][j] = Math.min(colMin[val][j], i); // Update the minimum row index for the color and column
                colMax[val][j] = Math.max(colMax[val][j], i); // Update the maximum row index for the color and column
            }
        }
        double ret = 0; // To store the maximum area of the triangle
        // Loop through the columns and colors and calculate the area of the possible triangles
        for (int col = 0; col < cols; col++) {
            for (int color1 = 0; color1 < 3; color1++) {
                for (int color2 = 0; color2 < 3; color2++) {
                    if (color1 == color2) continue; // Skip if the colors are the same
                    int color3 = 3 - color1 - color2; // Get the third color
                    // Check if the columns and rows are valid for the colors
                    if (colMin[color2][col] == Integer.MAX_VALUE || colMin[color1][col] == Integer.MAX_VALUE || minCol[color3] == Integer.MAX_VALUE)
                        continue;
                    // Calculate the area of the triangle formed by the colors and columns
                    ret = Math.max(ret, 0.5 * (colMax[color1][col] - colMin[color2][col] + 1) * (col - minCol[color3] + 1));
                    ret = Math.max(ret, 0.5 * (colMax[color1][col] - colMin[color2][col] + 1) * (maxCol[color3] - col + 1));
                }
            }
        }
        return (int) Math.ceil(ret); // Return the ceiling of the maximum area
    }

    // A helper method to get the color value for a character
    public int retCol(char ch) {
        if (ch == 'r') {
            return 0;
        } else if (ch == 'g') {
            return 1;
        }
        return 2;
    }
}
