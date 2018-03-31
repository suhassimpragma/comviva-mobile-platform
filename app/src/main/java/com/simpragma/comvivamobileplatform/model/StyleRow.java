package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

public class StyleRow {

    @SerializedName("doc")
    private Style style;

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StyleRow{");
        sb.append("style=").append(style);
        sb.append('}');
        return sb.toString();
    }
}