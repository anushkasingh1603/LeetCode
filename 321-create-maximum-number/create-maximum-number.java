class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] answer = new int[k];

        for (int i = 0; i <= k; i++) {

            int j = k - i;

            if (i > nums1.length || j > nums2.length) {
                continue;
            }

            int[] part1 = maxSubsequence(nums1, i);
            int[] part2 = maxSubsequence(nums2, j);

            int[] candidate = merge(part1, part2);

            if (greater(candidate, answer)) {
                answer = candidate;
            }
        }

        return answer;
    }

    private int[] maxSubsequence(int[] nums, int k) {

        int[] stack = new int[k];

        int top = 0;
        int remove = nums.length - k;

        for (int num : nums) {

            while (top > 0 && remove > 0 && stack[top - 1] < num) {
                top--;
                remove--;
            }

            if (top < k) {
                stack[top] = num;
                top++;
            } else {
                remove--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j)) {
                result[index++] = a[i++];
            } else {
                result[index++] = b[j++];
            }
        }

        return result;
    }

    private boolean greater(int[] a, int[] b) {

        int i = 0;

        while (i < a.length && i < b.length) {

            if (a[i] > b[i]) {
                return true;
            }

            if (a[i] < b[i]) {
                return false;
            }

            i++;
        }

        return a.length > b.length;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length) {

            if (a[i] > b[j]) {
                return true;
            }

            if (a[i] < b[j]) {
                return false;
            }

            i++;
            j++;
        }

        return i != a.length;
    }
}