class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> matches = new HashMap<>();

        for(int i = 0; i < strs.length; ++i)
        {
            int[] freq = new int[26];
            for(char c : strs[i].toCharArray())
            {
                ++freq[c-'a'];
            }

            String key = Arrays.toString(freq);

            if(matches.containsKey(key)) matches.get(key).add(strs[i]);
            else{
                ArrayList<String> brandNew = new ArrayList<>();
                brandNew.add(strs[i]);
                matches.put(key, brandNew);
            }
        }
       ArrayList<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : matches.entrySet())
        {
            answer.add(entry.getValue());
        }

        return answer;
    }
}
