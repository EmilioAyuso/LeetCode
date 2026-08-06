/**
 * You are given two integers n and t. 
 * Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.
 */
class Solution {
    public int smallestNumber(int n, int t) {
        // Find a bigger/equal numb to n that products of its digits is divisibe by t
        // Fuerza Bruta
        n--;
        while(true)
            if (productsDigits(++n) % t == 0)
                return n;
    }
    private int productsDigits(int n)
    {
        int s = 1;
        while(n > 9)
        {
            s *= n % 10;
            n /= 10;
        }
        return s * n;
    }
}