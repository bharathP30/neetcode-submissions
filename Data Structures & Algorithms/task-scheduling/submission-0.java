class Solution {
      public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for (char c : tasks ){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxFreq = Collections.max(map.values());
        int countMax = 0;
        for (int f : map.values()) {
            if (f == maxFreq) countMax++;
        }

        int minTime = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(minTime, tasks.length);
    }
}
