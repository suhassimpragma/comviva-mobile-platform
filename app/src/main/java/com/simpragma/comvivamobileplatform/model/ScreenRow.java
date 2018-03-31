package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

public class ScreenRow {

    @SerializedName("doc")
    private Screen screen;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScreenRow{");
        sb.append("screen=").append(screen);
        sb.append('}');
        return sb.toString();
    }
}