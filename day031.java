Verify Prime
................................
Given a number N, verify if N is prime or not.

Return 1 if N is prime, else return 0.

Example :

Input : 7
Output : True
................................................
public class Solution {
    public int isPrime(int A) {
         if (A <= 1)
            return 0;
 
        // Check if number is 2
        else if (A == 2)
            return 1;
 
        // Check if n is a multiple of 2
        else if (A % 2 == 0)
            return 0;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(A); i += 2) {
            if (A % i == 0)
                return 0;
        }
        return 1;
    }
    
}
