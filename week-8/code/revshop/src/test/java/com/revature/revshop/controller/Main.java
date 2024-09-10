package com.revature.revshop.controller;

import java.lang.*;
import java.util.*;

public class Main {

    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]= sc.nextInt();
        }

        int k = sc.nextInt();


        nums = rotate(nums, k);

        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }


    }

    public static int[] rotate(int[] nums, int k) {
        nums = nums;
        int n = nums.length;
        k %= n;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);

        return nums;
    }

    public static void reverse(int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }


}
