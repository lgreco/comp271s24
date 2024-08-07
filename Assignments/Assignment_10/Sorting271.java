import java.util.Arrays;

public class Sorting271 {

    /**
     * Merges two sorted arrays into a sorted array. The method takes advantage of
     * the fact that the two input arrays are sorted. It runs two indices to point
     * to the smallest unprocessed element for each array, and compares them,
     * selecting the smaller of the two to place in the output array. It then
     * advances the corresponding index and repeats. As soon as one of the two
     * indices runs out of bounds, the method traverses any left over elements in
     * the other array and copies them to the output array.
     * 
     * @param left  one of the two sorted arrays to merge
     * @param right the other sorted array to merge
     * @return an array with the elements of both input arrays, sorted also,
     *         preserving duplicates.
     */
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        // Initialize indices
        int i = 0; // left index
        int j = 0; // right index
        int k = 0; // merged index
        /*
         * Compare thel left-most elements from arrays left and right, selecting the
         * smallest of the two to place in array merge and eliminiating it from further
         * consideration by moving the corresponding arrays index by ++
         */
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        // If there are any elements remaining in array left, copy them directly to
        // merged
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        // If there are any elements remaining in array right, copy them directly to
        // merged
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        // Done
        return merged;
    } // method merge

    /**
     * 
     * @param array to sort; must have power-of-two number of elements. No test is
     *              performed to validate length compliance.
     * @return int[] with sorted values from array
     */
    public static int[] sort(int[] array) {
        System.out.println("\nAbout to sort " + Arrays.toString(array));
        int n = array.length; // for brevity
        // Size of arrays to merge in this iteration
        for (int size = 1; size <= n / 2; size *= 2) {
            /*
             * Spliting an array of length n into smaller arrays of the given size, result
             * into n/size subarrays. Assumign that n/size is a whole even number, that's a
             * (n/size)/2 pairs of subarrays.
             */
            int numberOfPairs = (n / size) / 2;
            // Work each pair
            for (int pair = 0; pair < numberOfPairs; pair++) {
                // Create the pair of left and right subarrays arrays of this size with elements
                // from corresponding positions in the input array
                int[] left = new int[size];
                int[] right = new int[size];
                // For clarity we define the following ...
                int leftStartsAt = 2 * pair * size;
                int rightStartsAt = (2 * pair + 1) * size;
                // ... and use them below.
                for (int i = 0; i < size; i++) {
                    left[i] = array[leftStartsAt + i];
                    right[i] = array[rightStartsAt + i];
                }
                // These arrays are sorted and we can merge them in a sorted array
                int[] temp = merge(left, right);
                // copy the merged array into the corresponding positions of the input array
                for (int j = 0; j < temp.length; j++) {
                    array[2 * pair * size + j] = temp[j];
                }
            }
        }
        return array;
    } // method sort

    public static void main(String[] args) {
        int[] test = { 8, 2, 6, 3, 7, 4, 1, 5 };
        System.out.println(Arrays.toString(test));
        int[] sortedTest = sort(test);
        System.out.println(Arrays.toString(sortedTest));
    }
}
