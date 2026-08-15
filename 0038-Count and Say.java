class Solution {
    public String countAndSay(int n) {
        String res = "1";
        StringBuilder aux;
        char num_repeat;
        int num_times;
        for (int i = 1; i<n; i++)
        {
            //aux = "";
            aux = new StringBuilder();

            num_repeat = res.charAt(0);
            num_times = 1;
            for(int j=1; j<res.length(); j++)
            {
                if (res.charAt(j) == num_repeat)
                    num_times++;
                else
                {
                    aux.append(num_times).append(num_repeat);
                    //aux += String.valueOf(num_times) + num_repeat;
                    num_repeat = res.charAt(j);
                    num_times = 1;
                }
            }

            aux.append(num_times).append(num_repeat);
            res = aux.toString();
        } 
        return res;
    }
}