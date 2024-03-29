package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	class Solution {
	    public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        backtrack(lists, new ArrayList<Integer>(), n, k, 1);
	        return lists;
	    }

		private void backtrack(List<List<Integer>> lists, List<Integer> list, int n, int k, int start) {
			// TODO Auto-generated method stub
			if (k < 0)return;
			if (k == 0)lists.add(new ArrayList<Integer>(list));
			else {
				for (int i = start; i <= n; i++) {
					list.add(i);
					backtrack(lists, list, n, k-1, i+1);
					list.remove(list.size()-1);
				}
			}
		}
	}
}