public class BossFunction {

    public static boolean boss(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    public static boolean helper(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index == nums.length) {
            return false;
        }

        boolean possible = helper(nums, index + 1, target - nums[index]); // take
        if (possible) {
            return true;
        } else {
            return helper(nums, index + 1, target); // not take
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 7;
        boolean result = boss(nums, target);

        System.out.println(result);
    }
}
