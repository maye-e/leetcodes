package _3.无重复字符的最长子串;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun("pwwkewe"));
    }

    /**
     * 标签：滑动窗口
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，
     * 此时 [start, end] 区间内不存在重复字符。
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     *
     * 理解：
     * 所谓 滑动窗口， 指的是 [start,end] 这个区间，称之为窗口。end 随循环向后移动，将遍历到的字符依次存入map，key 为字符，
     * value 为字符下标+1。当遇到重复字符时，更新 start 值，使其向前移动，跳过前面的重复字符，就像窗口滑过一样，因此叫做滑动窗口。
     * @param str
     * @return
     */
    public static int fun(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int len = str.length();
        int n = 0;//返回的最长无重复字符子串长度
        for (int start = 0, end = 0; end < len; end ++){
            Character ch = str.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch),start);
            }
            map.put(ch,end + 1);
            n = Math.max(n, end - start + 1);
        }
        return n;
    }
}
