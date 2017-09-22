package com.obob;


public class HalfFindTest {
	
	/**
	 * 默认按照升序排列的数组
	 * @param array
	 * @param begin
	 * @param end
	 * @param item
	 * @return
	 */
	public static int search(int[] array, int begin, int end, int item, Integer[] count) {
		count[0]++;
		if(begin < end) {
			int middle = (begin + end)/2;
			if(array[middle] >item){
				return search(array, begin, middle, item, count);
			}else if(array[middle] == item) {
				return middle;
			}else {
				return search(array, middle, end, item, count);
			}
		}else {
			if(array[begin] == item) {
				return begin;
			}else {
				return -1;
			}
		}
	}
	
	public static int halfFind(int[] array, int item) {
		if(array == null || array.length < 1) {
			return 0;
		}
		Integer[] count = {0};
		search(array, 0, array.length - 1, item, count);
		return count[0];
	}
	public static void main(String[] args) {
		int[] array = {1,5,8,11,19,22,31,35,40,45,48,49,50};
		System.out.println(halfFind(array, 48));
	}
}
