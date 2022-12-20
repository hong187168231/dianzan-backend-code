package com.likes.common.model.dto.result;

public class TjsscSizeMissDTO implements Comparable<TjsscSizeMissDTO> {

    private Integer missValue;

    private Integer missCount;

    public Integer getMissValue() {
        return missValue;
    }

    public void setMissValue(Integer missValue) {
        this.missValue = missValue;
    }

    public Integer getMissCount() {
        return missCount;
    }

    public void setMissCount(Integer missCount) {
        this.missCount = missCount;
    }

    @Override
    public int compareTo(TjsscSizeMissDTO o) {
        return this.missValue > o.getMissValue() ? -1 : 1;
    }
}
