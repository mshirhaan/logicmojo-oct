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


//using buckets

class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int result[] = new int[k];

        int count = 0;

        for (int i = bucket.size() - 1; i >= 0; i--) {
            List<Integer> mug = bucket.get(i);
            for (int j = 0; j < mug.size(); j++) {
                result[count++] = mug.get(j);
                if (count == k) {
                    return result;
                }
            }
        }

        return null;
    }
}
