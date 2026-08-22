class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mappings = new HashMap<>();
        for(String s : strs)
        {    
            int[] letter_counts = new int[26];
            for(int i = 0; i < s.length(); ++i)
            {
                ++letter_counts[s.charAt(i) - 'a'];
            }
            String key = Arrays.toString(letter_counts);
            if(!mappings.containsKey(key))
            {
                mappings.put(key, new ArrayList<>());
            }
            mappings.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> maps : mappings.entrySet())
        {
            result.add(maps.getValue());
        }
        return result;
    }
}