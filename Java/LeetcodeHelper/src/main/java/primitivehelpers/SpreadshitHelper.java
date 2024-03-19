package primitivehelpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SpreadshitHelper {
	static List<String> tags = new ArrayList<String>();
	static List<String> skills = new ArrayList<String>();
	static boolean[] results;
	static Scanner in = new Scanner(System.in);
	static boolean initializeTags(String input) {
		input.strip();
		if (input.equalsIgnoreCase("no"))return false;
		else tags.add(input);return true;
	}
	static boolean initializeSkills(String input) {
		input.strip();
		if (input.equalsIgnoreCase("no"))return false;
		else skills.add(input);return true;
	}
	static void subtractSkillsfromTags() {
		for(int i = 0; i < tags.size(); i++) {
			String tag = tags.get(i);
			StringBuilder mutable_tag = new StringBuilder(tag);
			for(String skill : skills) {
				int index = mutable_tag.indexOf(skill);
				if (index != -1) {
					int skill_length = skill.length();
					tag = mutable_tag.delete(index, index+skill_length).toString();
				}
			}
			tags.set(i, tag);
		}
	}
	static void initializeResults() {
		int tag_size = tags.size();
		results = new boolean[tag_size];
		for (int i = 0; i < tag_size; i++) {
			String tag = tags.get(i);
			results[i] = (tag.length() < 1);
		}
	}
	static void printArray() {
		for (boolean result : results) {
			System.out.println(result);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter tags (column c)");
		while(initializeTags(in.nextLine()));
		System.out.println("enter skills learnt (column i)");
		while(initializeSkills(in.nextLine()));
		subtractSkillsfromTags();
		initializeResults();
		printArray();
	}

}
