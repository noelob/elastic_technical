package com.github.noelob.elastic;

public class Merger {

    public static int[] merge(int[] arr1, int[] arr2) {
        // Return a sorted array that is a merge of the two incoming arrays
        // Assume imcoming arrays are sorted.

        if (arr1 == null && arr2 == null) {
            return new int[]{};
        }

        if (arr1 == null) {
            return arr2;
        }

        if (arr2 == null) {
            return arr1;
        }

        int length1 = arr1.length;
        int length2 = arr2.length;

        int[] merged = new int[length1 + length2];

        int ptr1 = 0;
        int ptr2 = 0;
        int mergePtr = 0;

        // Merge arrays until we reach the end of one of the incoming arrays
        while (ptr1 < length1 && ptr2 < length2) {
            if (arr1[ptr1] < arr2[ptr2]) {
                merged[mergePtr] = arr1[ptr1];
                ptr1++;
            } else {
                merged[mergePtr] = arr2[ptr2];
                ptr2++;
            }
            mergePtr++;
        }

        // if there are still entries in arr1, add those to the end
        if (ptr1 < length1) {
            while (ptr1 < length1) {
                merged[mergePtr] = arr1[ptr1];
                mergePtr++;
                ptr1++;
            }

        } else if (ptr2 < length2) {
            // otherwise if there are still entries in arr2, add those to the end
            while (ptr2 < length2) {
                merged[mergePtr] = arr2[ptr2];
                mergePtr++;
                ptr2++;
            }
        }

        return merged;
    }

}
