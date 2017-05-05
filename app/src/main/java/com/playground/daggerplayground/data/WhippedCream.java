package com.playground.daggerplayground.data;


import com.playground.daggerplayground.data.common.Extra;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class WhippedCream implements Extra {

    private String creamMode;

    public WhippedCream(String creamMode) {
        this.creamMode = creamMode;
    }

    @Override
    public String getMode() {
        return creamMode;
    }
}
