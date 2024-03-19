package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
	class Solution {
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        backtrack(lists, new ArrayList<Integer>(), k, n, 1);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int k, int n, int start) {
			// TODO Auto-generated method stub
			if (k < 0 || n < 0)return;
			if (k == 0 && n == 0)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = start; i <= 9; i++) {
					list.add(i);
					backtrack(lists, list, k-1, n-i, i+1);
					list.remove(list.size()-1);
				}
			}
		}
	}
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        backtrack(lists, new ArrayList<Integer>(), k, n, 1);
        return lists;
    }

	private void backtrack(List<List<Integer>> lists, List<Integer> list, int k, int n, int start) {
		// TODO Auto-generated method stub
		if (n < 0)return;
		if (n == 0 && k == 0)lists.add(new ArrayList<Integer>(list));
		else {
			for (int i = start; i <= 9; i++) {
				list.add(i);
				backtrack(lists, list, k-1, n-i, i+1);
				list.remove(list.size()-1);
			}
		}
	}
}