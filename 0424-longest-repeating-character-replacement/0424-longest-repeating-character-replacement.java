class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;      // highest frequency of a single character in current window
        int maxLen = 0;
        int[] freq = new int[26];  // frequency array for A-Z
        
        for (int right = 0; right < s.length(); right++) {
            
            int index = s.charAt(right) - 'A';
            freq[index]++;  // increase frequency of current character
            
            maxFreq = Math.max(maxFreq, freq[index]);  // update max frequency
            
            int windowSize = right - left + 1;
            
            // If more than k replacements needed → shrink window
            while (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                windowSize = right - left + 1;
            }
            
            maxLen = Math.max(maxLen, windowSize);
        }
        
        return maxLen;
    }
}