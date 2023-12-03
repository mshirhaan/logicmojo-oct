import java.util.ArrayList;
import java.util.List;

public class BossFunction {

    public static List<Integer> boss(int[] nums, int target) {
        return helper(nums, 0, target);
    }

    public static List<Integer> helper(int[] nums, int index, int target) {
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0 || index == nums.length) {
            return null;
        }

        List<Integer> bag = helper(nums, index + 1, target - nums[index]); // take
        if (bag != null) {
            bag.add(nums[index]);
            return bag;
        } else {
            return helper(nums, index + 1, target); // not take
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        List<Integer> result = boss(nums, target);

        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No solution found.");
        }
    }
}
