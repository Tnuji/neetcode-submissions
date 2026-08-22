class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoder = new StringBuilder();
        for(String s : strs)
        {
            encoder.append(s.length());
            encoder.append("#");
            encoder.append(s);
        }
        return encoder.toString();
    }

    public List<String> decode(String str) {
        
        //5#apple#7#racecar#4#word#
        List<String> decoder = new ArrayList<>();
        int i = 0;
        while (i < str.length())
        {
            int j = i;
            while(str.charAt(j) != '#')
            {
                ++j;
            }

            int length = Integer.parseInt(str.substring(i,j));
            String string = str.substring(j + 1, j + 1 + length);
            decoder.add(string);
            
            i = j + 1 + length;
        }
        return decoder;
    }
}
