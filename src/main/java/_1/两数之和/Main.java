package _1.两数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整型数组和一个目标值，找出数组中和为目标值的两个数。
 */
public class Main {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        int  target = 6;
        List<int[]> list = fun(array, target);
        for (int [] a : list){
            System.out.println(Arrays.toString(a));
        }
    }
    /**
     *
     * @param array 给定的数组
     * @param target 目标值
     * @return
     */
    public static List<int []> fun(int[] array, int target){
        List list = new ArrayList<int []>();
        for ( int i = 0; i < array.length -1; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[i] + array[j] == target){
                    int[] r = {array[i],array[j]};
                    list.add(r);
                }
            }
        }
        return list;
    }
}
