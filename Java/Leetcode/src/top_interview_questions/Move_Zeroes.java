package top_interview_questions;

import java.util.Arrays;

public class Move_Zeroes {
	class Solution {
	    public void moveZeroes(int[] nums) {
	        int nonZeroCtr = 0;
	        for (int num : nums) {
	        	if (num != 0)nums[nonZeroCtr++] = num;
	        }
	        while (nonZeroCtr < nums.length) {
	        	nums[nonZeroCtr++] = 0;
	        }
	    }
	}
}