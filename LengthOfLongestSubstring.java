//Brute Force
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) {
            return s.length();
        }
        char[] arr =  s.toCharArray();
        int max = 0;

        for(int i = 0; i<arr.length; i++) {
            Set<Character> set = new HashSet<>();
            set.add(arr[i]);
            max = Math.max(max, set.size());
            for(int j = i+1; j<arr.length; j++) {
                if(!set.contains(arr[j])) {
                    set.add(arr[j]);
                    max = Math.max(max, set.size());
                } else {
                    
                    break;
                }
            }
        }
        return max;
    }
}

//Optimal O(n) two pointer
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) {
            return s.length();
        }

        int i = 0;
        int j = 1;

        int max = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));

        while(j<s.length()) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));

            max = Math.max(max, (j-i+1));
            j++;
        }
        return max;
    }
}
