import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = Arrays.asList("");
        String[] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // 7 and 9 has 4 possib not 3
        String letter;
        for(int i=0; i<digits.length(); i++) //for each digit in digits
        {
            letter = letters[digits.charAt(i) - '0' - 2]; // Take the letters represented by that digit
            List<String> aux = new ArrayList<>();
            for (int j = 0; j < res.size(); j++)
                for (int k=0; k < letter.length(); k++)
                    aux.add(res.get(j) + letter.charAt(k)); //We add for each previous result, the new possibilities of letters

            res = aux;
        }
        return res;
    }
}