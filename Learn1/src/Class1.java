package example1;

public class Class1 {
	
/*
 * LeetCode1 Two Sums
*/
	public static void main(String[] args) {
		Solution solution1 = new Solution();
		int[] nums = {3,2,4};
		int target = 6;
		int[] result = solution1.twoSum(nums, target);
		for(int temp : result) {
			System.out.print(temp + " ");
		}
	}

}
