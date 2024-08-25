public class P128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int longest = 0;
        Set<Integer> numSet = new HashSet<>();
        // enter all the values in the
        for(int n : nums){
            numSet.add(n);
        }
        // for each value in the map
        for (int num : numSet) {
            // Only start counting if this is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
