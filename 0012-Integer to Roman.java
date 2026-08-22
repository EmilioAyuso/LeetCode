/**
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
 * Given an integer, convert it to a Roman numeral.
*/
class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] valuesToRom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0; num>0; i++)
        {
            while(num>=values[i])
            {
                num -= values[i];
                res.append(valuesToRom[i]); 
            }
        }
        return res.toString();
    }
        /*
        StringBuilder res = new StringBuilder();
        //Separate num in each val
        int len = numOfDigits(num);
        int numAux;
        while(len>0)
        {
            len--;
            numAux = num / (int)Math.pow(10,len) * (int) Math.pow(10,len);
            //System.out.println(numAux);
            res.append(numToRoman(numAux, len));
            num -= numAux;
        }

        return res.toString();
    }
    private int numOfDigits(int num)
    {
        int res = 1;
        while(num >= Math.pow(10,res))
            res++;
        return res;
    }
    // 1. if not 4 or 9 -> maxim val
    // 2. if 4 or 9 -> 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM)
    // 3. Only can append  (I, X, C, M), not (V, L, D)
    private String numToRoman(int num, int len)
    {
        String res = "";
        int firstDigit = num/(int)Math.pow(10,len);
        if (firstDigit == 4 || firstDigit == 9)
        {
            switch (num)
            {
                case 4: return "IV";
                case 9: return "IX";
                case 40: return "XL";
                case 90: return "XC";
                case 400: return "CD";
                case 900: return "CM";
            }
        }
        else
        {
            while(num>0)
            {
                if(num>=1000)
                {
                    num-=1000;
                    res+="M";
                }
                else if(num>=500)
                {
                    num-=500;
                    res+="D";
                }
                else if(num>=100)
                {
                    num-=100;
                    res+="C";
                }
                else if(num>=50)
                {
                    num-=50;
                    res+="L";
                }
                else if(num>=10)
                {
                    num-=10;
                    res+="X";
                }
                else if(num>=5)
                {
                    num-=5;
                    res+="V";
                }
                else if(num>=1)
                {
                    num-=1;
                    res+="I";
                }
            }
        }
        return res;
    }
    */
}