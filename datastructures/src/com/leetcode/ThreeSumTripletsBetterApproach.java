package com.leetcode;

import java.util.*;

public class ThreeSumTripletsBetterApproach {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ll = threeSum(nums);
        System.out.println(ll);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            int requiredValue = -(nums[i]);

            int left = i+1;
            int right = nums.length-1;

            if(i>1){
                if(nums[i-1] == nums[i]){
                    continue;
                }
            }
            List<Integer> ll = null;
            while(left<right){
                if(nums[left]+nums[right] == requiredValue){
                    ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[left]);
                    ll.add(nums[right]);
                    set.add(ll);
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]>requiredValue){
                    right--;
                }else if(nums[left]+nums[right]<requiredValue){
                    left++;
                }
            }
        }

        return set.stream().toList();
    }
}

