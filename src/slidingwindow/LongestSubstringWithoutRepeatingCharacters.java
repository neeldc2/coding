package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        int currentStart = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!characterIntegerMap.containsKey(ch)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
                characterIntegerMap.put(ch, i);
            } else {
                int index = characterIntegerMap.get(ch);
                for (int k = currentStart; k <= index; k++) {
                    characterIntegerMap.remove(s.charAt(k));
                }
                currentStart = index + 1;
                currentLength = i - index;
                characterIntegerMap.put(ch, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("cadbzabcd"));
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
