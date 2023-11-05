class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int arr1[] = new int[26];
        int arr2[] = new int[26];

        for(int i = 0; i<s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            arr1[c1 - 'a']++;
            arr2[c2 - 'a']++;
        }

       int count = 0;

       for(int i = 0; i < 26; i++) {
           if(arr1[i] == arr2[i]) {
               count++;
           }
       }

       if(count == 26) return true;

       //Sliding window begins
       
       int pointer = s1.length();

       while(pointer < s2.length()) {
        int addIdx = s2.charAt(pointer) - 'a';
        int removeIdx = s2.charAt(pointer-s1.length()) - 'a';

        arr2[addIdx]++;
        arr2[removeIdx]--;
        if(addIdx == removeIdx) {
            pointer++;
            continue;
        }
        if(arr2[addIdx] == arr1[addIdx]) {
            count++;
        } else if(arr2[addIdx] == arr1[addIdx]+1) {
            count--;
        }

        if(arr2[removeIdx] == arr1[removeIdx]) {
            count++;
        } else if(arr2[removeIdx]+1 == arr1[removeIdx]) {
            count--;
        }
        if(count == 26) return true;

        pointer++;
       }
        return false;
    }
}
