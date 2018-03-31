package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Screen {

    @SerializedName("uiElements")
    private List<UiElement> uiElements;

    @SerializedName("type")
    private String type;

    public List<UiElement> getUiElements() {
        return uiElements;
    }

    public void setUiElements(List<UiElement> uiElements) {
        this.uiElements = uiElements;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Screen{");
        sb.append("uiElements=").append(uiElements);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}