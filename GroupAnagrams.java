
// O(n2logn) 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }

        List<List<String>> values = new ArrayList<>(map.values());

        return values;
    }
}




//Tc - O(n2)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int [] arr = new int[26];

            for(char c : str.toCharArray()) {
                int index =  c - 'a';
                arr[index]++;
            }
        
            String key = Arrays.toString(arr);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        List<List<String>> values = new ArrayList<>(map.values());

        return values;
    }
}
