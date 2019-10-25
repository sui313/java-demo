package arrSortFind;

import java.util.Arrays;

public class arrSortFind {
	public static void main(String[] args) {
		int array[] = { 2, 5, -1, 2, 34, 555, 11, 44, 0, 9 };
		Arrays.sort(array);
		printArray("数组排序结果为", array);
		int index = Arrays.binarySearch(array, 2);
		System.out.println("元素2在第 " + index + " 个位置");
	}

	private static void printArray(String message, int array[]) {
		System.out.println(message + ":[length:" + array.length + "]");
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				System.out.println(",");
			}
			System.out.print(array[i]);
		}
		System.out.println();
	}

}
