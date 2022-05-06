public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int total_prod = 1;
        int zero_num = 0;
        int zero_index = 0;
        int[] cur = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zero_num == 0 && nums[i] != 0)
                cur[i] = total_prod;
            else if (zero_num == 2)
                return new int[nums.length];
            else {
                if (nums[i] != 0)
                    cur[i] = 0;
                else
                    cur[i] = total_prod;
            }

            if (nums[i] != 0)
                total_prod *= nums[i];
            else {
                zero_num++;
                zero_index = i;
            }
        }

        if (zero_num == 2)
            return new int[nums.length];

        if (zero_num == 1) {
            int[] ret = new int[nums.length];
            ret[zero_index] = total_prod;
            return ret;
        }

        total_prod = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            cur[i] *= total_prod;
            total_prod *= nums[i];
        }

        return cur;
    }
}
