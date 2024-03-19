package primitivehelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turn_Title_Into_URL {
	static void manipulate(String title) {
		StringBuilder url = new StringBuilder();
		url.append("https://leetcode.com/problems/");
		boolean flag = false;
		for (char ch : title.toCharArray()) {
			if (!flag && Character.isWhitespace(ch)) {
				flag = true;
				continue;
			}
			if (!flag) continue;
			if (flag) {
				if (Character.isLetter(ch) || Character.isDigit(ch)) {
					ch = Character.toLowerCase(ch);
					url.append(ch);
				}
				if (ch == '-')url.append(ch);
				if (Character.isWhitespace(ch)) {
					ch = '-';
					url.append(ch);
				}
			}
		}
		url.append("/description/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions");
		System.out.println(url.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter how many elements: ");
		int elements = in.nextInt();
		System.out.println("Paste elements below in TSV format");
		in.nextLine();
		List<String> strings = new ArrayList<String>();
		for (int i = 0; i < elements; i++) {
			strings.add(in.nextLine());
		}
		for (String string : strings) {
			manipulate(string);
		}
	}
}
