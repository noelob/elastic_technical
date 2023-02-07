package com.github.noelob.elastic;

public class DataSet {
    int[] first;
    int[] second;
    int[] result;

    public DataSet(int[] first, int[] second, int[] result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }

    public int[] getFirst() {
        return first;
    }

    public int[] getSecond() {
        return second;
    }

    public int[] getResult() {
        return result;
    }
}
