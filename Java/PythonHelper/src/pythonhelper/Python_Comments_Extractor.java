package pythonhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Python_Comments_Extractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(1, 2, 3);
		Scanner in = new Scanner(System.in);
		List<String> lines = new ArrayList<String>();
		while(lines.size() == 0 || !lines.get(lines.size()-1).equals("gg")) {
			String line = in.nextLine();
			lines.add(line);
		}
		boolean flag = false;
		for (String line : lines) {
			if (!flag) {
				if (line.contains("\"\"\"")) {
					flag = true;
//					System.out.print(flag);
					printEverythingAfterTripleQuotations(line);
				}
				else printEverythingAfterHashtag(line);
				continue;
			}
			else if (flag) {
				if (line.contains("\"\"\"")) {
					flag = false;
//					System.out.print(flag);
					printEverythingBeforeTripleQuotations(line);
				}
				else System.out.println(line);
				continue;
			}
		}
	}

	private static void test(int... args) {
		// TODO Auto-generated method stub
		for (int arg : args) {
			System.out.println(arg);
		}
	}

	private static void printEverythingBeforeTripleQuotations(String line) {
		// TODO Auto-generated method stub
		int indexOfLastHashtag = line.lastIndexOf("\"\"\"")+3;
//		System.out.print(indexOfLastHashtag);
		System.out.println(line.substring(0, indexOfLastHashtag));
	}

	private static void printEverythingAfterHashtag(String line) {
		// TODO Auto-generated method stub
		int indexOfHashtag = line.indexOf('#');
//		System.out.print(indexOfHashtag);
		if (indexOfHashtag != -1)System.out.println(line.substring(indexOfHashtag));
		else if (line.length() == 0) System.out.println();
	}

	private static void printEverythingAfterTripleQuotations(String line) {
		// TODO Auto-generated method stub
		int indexOfLastQuotation = line.indexOf("\"\"\"");
//		System.out.print(indexOfLastQuotation);
		System.out.println(line.substring(indexOfLastQuotation));
	}

}
