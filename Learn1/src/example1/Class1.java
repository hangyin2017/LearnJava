package example1;

public class Class1 {
	
/*
 * LeetCode1 Two Sums
*/
	public static void main(String[] args) {
		Solution solution1 = new Solution();
		int[] nums = {2,7,11,17};
		int target = 18;
		int[] result = solution1.twoSum(nums, target);
		for(int temp : result) {
			System.out.print(temp + " ");
		}
	}

}
