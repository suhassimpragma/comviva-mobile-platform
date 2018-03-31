package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("type")
    private String type;

    @SerializedName("background")
    private String background;

    @SerializedName("padding")
    private int padding;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Property{");
        sb.append("type='").append(type).append('\'');
        sb.append(", background='").append(background).append('\'');
        sb.append(", padding=").append(padding);
        sb.append('}');
        return sb.toString();
    }
}