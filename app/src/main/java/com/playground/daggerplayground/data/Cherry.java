package com.playground.daggerplayground.data;

/**
 * Created by petnagy on 2017. 05. 02..
 */

public class Cherry implements Extra {

    private String cherryMode;

    public Cherry(String cherryMode) {
        this.cherryMode = cherryMode;
    }

    @Override
    public String getMode() {
        return cherryMode;
    }
}
