package leetcode.chapter01string;

import java.util.Arrays;
import java.util.Stack;

// 66. Plus One
// https://leetcode.com/problems/plus-one/
public class Q04PlusOne {

    public static void main(String[] args) {

        int[] digits1 = {1,2,3};
        int[] digits2 = {9,9,9};
        int[] digits3 = {1,2,3};
        int[] digits4 = {9,9,9};
        int[] digits5 = {8,9,9,9};

        Q04PlusOne q04PlusOne = new Q04PlusOne();
        System.out.println(Arrays.toString(q04PlusOne.mySolve(digits1)));
        System.out.println(Arrays.toString(q04PlusOne.mySolve(digits2)));

        System.out.println(Arrays.toString(q04PlusOne.plusOne(digits3)));
        System.out.println(Arrays.toString(q04PlusOne.plusOne(digits4)));
        System.out.println(Arrays.toString(q04PlusOne.plusOne(digits5)));
    }

    public int[] plusOne(int[] digits) {

        int length = digits.length;

        for(int i=length-1;i>=0;i--) {
            digits[i]++;
            if(digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[length+1];
        result[0] = 1;

        return result;
    }

    // 2024-03-22 풀이
    public int[] mySolve(int[] digits) {

        Stack<Integer> stack = new Stack<>();

        digits[digits.length-1] += 1;

        int raisedValue = 0;
        for(int i=digits.length-1;i>=0;i--) {
            int sum = digits[i] + raisedValue;
            int share = sum / 10;
            int reminder = sum % 10;

            stack.push(reminder);
            raisedValue = Math.max(share, 0);
        }

        if(raisedValue > 0) {
            stack.push(raisedValue);
        }

        int[] result = new int[stack.size()];
        for (int i=0;i<result.length;i++) {
            result[i] = stack.pop();
        }

        return result;
    }
}
