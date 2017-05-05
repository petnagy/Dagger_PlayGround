package com.playground.daggerplayground.data;

import com.playground.daggerplayground.data.common.Extra;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class Ice implements Extra {

    private String iceMode;

    public Ice(String iceMode) {
        this.iceMode = iceMode;
    }

    @Override
    public String getMode() {
        return iceMode;
    }
}
