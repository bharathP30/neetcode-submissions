class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s1.length(); i++ ){
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (map1.equals(map2)) return true;

        int j = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

                char ch = s2.charAt(j);
                map2.put(ch, map2.get(ch) - 1);
                if (map2.get(ch) == 0) map2.remove(ch);
                j++;
            

            if( map1.equals(map2) ) return true;
        }
        return false;
    }
}
