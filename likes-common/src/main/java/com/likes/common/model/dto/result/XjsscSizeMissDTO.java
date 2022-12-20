package com.likes.common.model.dto.result;

/**
 * 新疆时时彩返回值列表
 */
public class XjsscSizeMissDTO implements Comparable<XjsscSizeMissDTO> {
    //遗漏值
    private Integer missValue;
    //遗漏数
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
    public int compareTo(XjsscSizeMissDTO o) {
        return this.missValue > o.getMissValue() ? -1 : 1;
    }
}
