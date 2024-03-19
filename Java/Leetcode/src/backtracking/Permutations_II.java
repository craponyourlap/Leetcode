package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        backtrack(lists, new ArrayList<Integer>(), nums, new boolean[nums.length]);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] using) {
			// TODO Auto-generated method stub
			if (list.size() == nums.length)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = 0; i < nums.length; i++) {
					if (using[i] || i > 0 && nums[i] == nums[i-1] && !using[i-1])continue;
					using[i] = true;
					list.add(nums[i]);
					backtrack(lists, list, nums, using);
					using[i] = false;
					list.remove(list.size()-1);
				}
			}
		}
	}
}