package com.leetcode;

import java.util.*;

public class FourSumBetterSolution {

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        System.out.println(aprroaach1(nums,target));
    }

    private static List<List<Integer>> aprroaach1(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = null;

        if(nums.length == 4 && nums[0]+nums[1]+nums[2]+nums[3]==target){
            list = new ArrayList<>();
            list.add(nums[0]);
            list.add(nums[1]);
            list.add(nums[2]);
            list.add(nums[3]);
            List<List<Integer>> sl = new ArrayList<>();
            sl.add(list);
            return sl;
        }else if(nums.length>4){
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){

                    int left = j+1;
                    int right = nums.length-1;
                    int newTarget = target -(nums[i]+nums[j]);
                    while(left<right){
                        if(nums[left]+nums[right]>newTarget){
                            right--;
                        }else if(nums[left]+nums[right]<newTarget){
                            left++;
                        }else{
                            list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            set.add(list);
                            left++;
                            right--;
                        }
                    }
                }
            }
            return set.stream().toList();
        }else{
            return new ArrayList();
        }
    }
}
