package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        backtrack(lists, new ArrayList<Integer>(), candidates, target, 0);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int start) {
			// TODO Auto-generated method stub
			if (target < 0)return;
			if (target == 0)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = start; i < nums.length; i++) {
					list.add(nums[i]);
					backtrack(lists, list, nums, target-nums[i], i);
					list.remove(list.size()-1);
				}
			}
		}
	}
}
