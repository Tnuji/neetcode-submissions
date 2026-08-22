class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key))
            return "";

        TreeMap<Integer, String> tree = map.get(key);

        Integer time = tree.floorKey(timestamp);

        if (time == null)
            return "";

        return tree.get(time);
    }
}
