package top.ccheng.leetcode.lcof;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ccheng
 * @date 2020/10/31
 */
public class Lcof5 {

    public String replaceSpace1(String s) {
        //假设所有字符都是空格，则临时字符数组至少需要三倍的空间
        char[] arr = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = c;
            }
        }
        return new String(arr, 0, index);
    }

    public String replaceSpace2(String s) {
        //先统计空格个数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        //没有空格，原样返回
        if (count == 0) {
            return s;
        }

        //新字符数组是 非空格个数+空格个数*3
        char[] arr = new char[s.length() - count + count * 3];
        int index = 0;
        //遍历替换空格
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = c;
            }
        }
        return new String(arr, 0, index);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        Lcof5 lcof5 = new Lcof5();
        System.out.println(lcof5.replaceSpace1(s));
        System.out.println(lcof5.replaceSpace2(s));
    }
}
