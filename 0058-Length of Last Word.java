class Solution {
    public int lengthOfLastWord(String s) {
        int pos = s.length()-1;

        while(pos>=0 && s.charAt(pos) == ' ')
            pos--; //skip last whitespaces

        if (pos<=0)
            return pos+1; // when its just whitespaces or just 1 letter-word

        // else -> pos = last letter of last word
        int pos_first = 0;
        while(pos_first>=0 && s.charAt(pos_first) != ' ')
            pos_first--; //look for the first letter of that last word

        return pos-pos_first;
    }
}