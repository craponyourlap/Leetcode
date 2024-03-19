package top_interview_questions;

public class Remove_Duplicates_from_Sorted_Array {
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        int notDuplicateCtr = 0;
	        for (int i = 0; i < nums.length; i++) {
	        	if (i > 0 && nums[i] == nums[i-1])continue;
	        	nums[notDuplicateCtr++] = nums[i];
	        }
	        return notDuplicateCtr;
	    }
	}
}
