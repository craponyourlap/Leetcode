package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	class Solution {
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        backtrack(lists, new ArrayList<Integer>(), nums);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums) {
			// TODO Auto-generated method stub
			if (list.size() == nums.length)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = 0; i < nums.length; i++) {
					if (list.contains(nums[i]))continue;
					list.add(nums[i]);
					backtrack(lists, list, nums);
					list.remove(list.size()-1);
				}
			}
		}
	}
}