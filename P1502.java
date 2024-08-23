public class P1502 {
    // Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=2) return true;
        // I should sort the array
        Arrays.sort(arr); // n log(n)
        // now calculate the difference beween the first two entries
        int diff = arr[1] - arr[0];
        // check if all consequtive have the same difference
        for(int i = 1; i < arr.length-1; i++){ // n
            if(diff != (arr[i+1] - arr[i])) return false;
        }
        return true;
    }
}
