import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        int a = 0;
        int b = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(b<s.length())
        {
            if(map.get(s.charAt(b)) == null) //new char
            {       
                if(b-a+1>res)
                    res = b-a+1;
                map.put(s.charAt(b++),1);
            }
            else
            {
                map.remove(s.charAt(a++));
            }
        }
        return res;
    }
}