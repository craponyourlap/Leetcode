package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sums_II {
	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        Arrays.sort(candidates);
	        backtrack(lists, new ArrayList<Integer>(), candidates, target, 0);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int start) {
			// TODO Auto-generated method stub
			if (target < 0)return;
			if (target == 0)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = start; i < nums.length; i++) {
					if (i > start && nums[i] == nums[i-1])continue;
					list.add(nums[i]);
					backtrack(lists, list, nums, target-nums[i], i+1);
					list.remove(list.size()-1);
				}
			}
		}
	}
}