//Sorting Hashmap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int num : nums) {
         if(!map.containsKey(num)) {
           map.put(num, 0);
         }
         map.put(num, map.get(num)+1);
       }

       List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
       Collections.sort(list, (entry1, entry2) -> entry2.getValue() - entry1.getValue());

       int[]result = new int[k];

       for(int i = 0; i<k; i++) {
         result[i] = list.get(i).getKey();
       }


      return result;
    }
}
