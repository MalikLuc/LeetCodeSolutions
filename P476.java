public class P476 {
    public int findComplement(int num) {
        int numBits = Integer.toBinaryString(num).length();  // Calculate the number of bits
        int mask = (1 << numBits) - 1;  // Create a mask of that length
        return (~num) & mask;
    }
}
