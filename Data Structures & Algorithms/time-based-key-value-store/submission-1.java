class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        TreeMap<Integer, String> temp = map.get(key);

        Integer time = temp.floorKey(timestamp);
        if(time == null) return "";

        return temp.get(time);
    }
}
