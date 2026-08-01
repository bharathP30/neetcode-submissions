class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int maxFreq = 0;
        int left = 0;
        
        for ( int right = 0; right < s.length(); right++ ){
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while((right - left + 1) - maxFreq > k) {
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                left++;
            } 
            longest = Math.max(right - left + 1, longest);
        } return longest;
    }
}
