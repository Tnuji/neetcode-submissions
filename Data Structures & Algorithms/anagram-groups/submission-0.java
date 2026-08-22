class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>  mappings = new HashMap<>();
        for(String s : strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            if(!mappings.containsKey(temp))
            {
                mappings.put(temp, new ArrayList<>());
            }

            mappings.get(temp).add(s);
        }
        
        List<List<String>> solution = new ArrayList<>();
        for(Map.Entry<String , List<String>> entry : mappings.entrySet())
        {
            solution.add(entry.getValue());
        }
        return solution;
    }
}
