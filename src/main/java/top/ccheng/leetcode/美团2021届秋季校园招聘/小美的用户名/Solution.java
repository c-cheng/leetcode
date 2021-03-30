package top.ccheng.leetcode.美团2021届秋季校园招聘.小美的用户名;

import java.util.Scanner;

/**
 * 小美的用户名
 * <p>
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 * <p>
 * 用户名的首字符必须是大写或者小写字母。
 * <p>
 * 用户名只能包含大小写字母，数字。
 * <p>
 * 用户名需要包含至少一个字母和一个数字。
 * <p>
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 * <p>
 * 格式：
 * <p>
 * 输入：
 * <p>
 * - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
 * <p>
 * - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * <p>
 * 输出：
 * <p>
 * - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * <p>
 * 5
 * <p>
 * Ooook
 * <p>
 * Hhhh666
 * <p>
 * ABCD
 * <p>
 * Meituan
 * <p>
 * 6666
 * <p>
 * 输出：
 * <p>
 * Wrong
 * <p>
 * Accept
 * <p>
 * Wrong
 * <p>
 * Wrong
 * <p>
 * Wrong
 * <p>
 * 提示：
 * <p>
 * 1 <= T <= 100
 * s 的长度不超过 20
 * <p>
 * 作者：美团
 * 链接：https://leetcode-cn.com/leetbook/read/meituan/ohsjgd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author ccheng
 * @date 2021-03-24
 */
public class Solution {
    private static final String ACCEPT = "Accept";
    private static final String WRONG = "Wrong";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = scanner.nextLine();
        }
        for (String name : names) {
            System.out.println(checkName(name));
        }
        scanner.close();
    }

    private static String checkName(String name) {
        //首字符必须是大写或者小写字母
        char firstChar = name.charAt(0);
        if (!isLetter(firstChar)) {
            return WRONG;
        }
        //至少包含一个数字，首字符已经是字母
        boolean hasNumber = false;
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            if (isNumber(c)) {
                hasNumber = true;
            } else {
                //只能包含大小写字母，数字
                if (!isLetter(c)) {
                    return WRONG;
                }
            }
        }
        return hasNumber ? ACCEPT : WRONG;
    }

    /**
     * 是否字母
     */
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * 是否数字
     */
    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
