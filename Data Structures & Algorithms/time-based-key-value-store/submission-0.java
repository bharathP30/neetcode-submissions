class TimeMap {
    class Info {
        String mood;
        int time;

        Info(String moodVal, int timeVal) {
            this.mood = moodVal;
            this.time = timeVal;
        }
    }

    Map<String, List<Info>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>());
        timeMap.get(key).add(new Info(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        List<Info> infos = timeMap.get(key);
        int lo = 0, hi = infos.size() - 1;
        String res = "";

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (infos.get(mid).time <= timestamp) {
                res = infos.get(mid).mood;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } return res;
    }
}
