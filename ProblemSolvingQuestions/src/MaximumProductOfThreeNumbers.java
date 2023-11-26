import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] chor = {-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(chor));
    }
    public static int maximumProduct(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[n-1]*nums[0]*nums[1]) ;
    }
}
