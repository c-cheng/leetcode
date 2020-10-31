package top.ccheng.leetcode.lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a>https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ccheng
 * @date 2020/10/31
 */
public class Lcof3 {

    private static final int notFind = -1;

    /**
     * 先排序，然后循环判断前后两个是否重复
     */
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                return notFind;
            }
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return notFind;
    }

    /**
     * 使用一个集合存放遍历过的数，如果遍历的数已经在集合中，则当前的数为重复的数
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> existSet = new HashSet<Integer>();
        for (int num : nums) {
            if (existSet.contains(num)) {
                return num;
            } else {
                existSet.add(num);
            }
        }
        return notFind;
    }

    /**
     * 由于所有的数都在0~n-1的范围，所以可以创建一个长度为n的数组来存放遍历过的数，将遍历的数作为新数组的下标
     * 相当于是基于集合判断重复的优化
     */
    public int findRepeatNumber3(int[] nums) {
        int[] existArr = new int[nums.length];
        for (int num : nums) {
            existArr[num]++;
            if (existArr[num] > 1) {
                return num;
            }
        }
        return notFind;
    }

    /**
     * 由于所有的数都在0~n-1的范围，假设所有数字都不重复，则nums刚好是0~n-1所有的数
     * 对nums进行原地排序，如果排序时遇到有两个数要放到同一个位置，说明重复了
     */
    public int findRepeatNumber4(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }else {
                    temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return notFind;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        Lcof3 lcof3 = new Lcof3();
        System.out.println(lcof3.findRepeatNumber1(array));
        System.out.println(lcof3.findRepeatNumber2(array));
        System.out.println(lcof3.findRepeatNumber3(array));
        System.out.println(lcof3.findRepeatNumber4(array));
    }
}
