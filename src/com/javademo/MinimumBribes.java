package com.javademo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MinimumBribes {
	// Add line by github
	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		boolean isChaotic = false;
		Map<Integer, Integer> moveCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < q.length; i++) {
			boolean flag = false;
			for (int j = 0; j < q.length - 1; j++) {

				if (q[j] > q[j + 1]) {
					flag = true;
					Integer count = moveCount.get(q[j]);
					if (count != null) {
						Integer newCount = ++count;
						if (newCount > 2) {
							isChaotic = true;
							flag = false;
							break;
						}
						moveCount.put(q[j], newCount);
					} else {
						moveCount.put(q[j], 1);
					}
					int temp = q[j];
					q[j] = q[j + 1];
					q[j + 1] = temp;
				}

			}

			if (!flag) {
				break;
			}

		}
		if (isChaotic) {
			System.out.println("Too chaotic");
		} else {
			int total = 0;
			for (Entry<Integer, Integer> local : moveCount.entrySet()) {
				total += local.getValue();
			}
			System.out.println(total);
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
