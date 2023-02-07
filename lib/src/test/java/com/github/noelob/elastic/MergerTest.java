package com.github.noelob.elastic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.noelob.elastic.Merger.merge;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergerTest {

    @ParameterizedTest
    @MethodSource
    void mergeTest(DataSet data) {
        assertArrayEquals(data.getResult(), merge(data.getFirst(), data.getSecond()));
    }

    private static Stream<DataSet> mergeTest() {
        return Stream.of(
                // Happy path
                new DataSet(
                        new int[]{1, 3, 4, 15, 26, 57},
                        new int[]{2, 5, 7, 11, 21, 45},
                        new int[]{1, 2, 3, 4, 5, 7, 11, 15, 21, 26, 45, 57}
                ),
                // Different lengths
                new DataSet(
                        new int[]{1, 6, 57},
                        new int[]{2, 5, 7, 11, 21, 45},
                        new int[]{1, 2, 5, 6, 7, 11, 21, 45, 57}
                ),
                // Both arrays empty
                new DataSet(
                        new int[]{},
                        new int[]{},
                        new int[]{}
                ),
                // One array empty
                new DataSet(
                        new int[]{},
                        new int[]{2, 5, 7, 11, 21, 45},
                        new int[]{2, 5, 7, 11, 21, 45}
                ),
                // Both arrays null
                new DataSet(
                        null,
                        null,
                        new int[]{}
                ),
                // First array null
                new DataSet(
                        null,
                        new int[]{2, 5, 7, 11, 21, 45},
                        new int[]{2, 5, 7, 11, 21, 45}
                ),
                // Second array null
                new DataSet(
                        new int[]{1, 3, 4, 15, 26, 57},
                        null,
                        new int[]{1, 3, 4, 15, 26, 57}
                ),
                // Negatives & Zero
                new DataSet(
                        new int[]{-3, -1, 4},
                        new int[]{-5, 0, 2},
                        new int[]{-5, -3, -1, 0, 2, 4}
                )
        );
    }
}