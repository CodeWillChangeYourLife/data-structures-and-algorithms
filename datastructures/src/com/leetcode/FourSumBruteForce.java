package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class FourSumBruteForce {

    public static void main(String[] args) {

      //  int[] nums = {1, 0, -1, 0, -2, 2};
      int [] nums = {1000000000, 1000000000, 1000000000, 1000000000};
      int target = -294967296;
        //o/p - [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        List<Integer> list = null;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            set.add(list);
                        }
                    }
                }
            }
        }
        System.out.println(set);
    }
}
