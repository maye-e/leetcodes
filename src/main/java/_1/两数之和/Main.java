package _1.两数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整型数组和一个目标值，找出数组中和为目标值的两个数。
 */
public class Main {

    private static int length;

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        int  target = 6;
        List<int[]> list = fun2(array, target);
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
    public static List<int []> fun1(int[] array, int target){
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

    public static List fun2(int [] array, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int length = array.length;
        for (int i = 0; i < length; i ++){
            int val = target - array[i];
            if (map.containsKey(val)){
                int[] r = {val, array[i]};
                list.add(r);
            }
            map.put(array[i],i);
        }
        return list;
    }
}
