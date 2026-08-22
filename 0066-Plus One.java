/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        boolean added = false;
        int i = digits.length-1;
        while(!added)
        {
            if (i<0) // if digits was 9999 or sum like that
            {
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res; 
            }
            else if (digits[i] == 9) //if the numb we have to add 1 modifysthe next digkt
            {
                digits[i--] = 0;
            }
            else // when the numb is < 9 so you should only changed that
            {
                digits[i] = digits[i] + 1;
                added = true;
            }
        } 
        return digits;    
    }
}