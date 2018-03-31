package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

public class UiElement {

    @SerializedName("id")
    private int id;

    @SerializedName("slNo")
    private int slNo;

    @SerializedName("type")
    private String type;

    @SerializedName("inputType")
    private String inputType;

    @SerializedName("text")
    private String text;

    @SerializedName("hint")
    private String hint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UiElement{");
        sb.append("id=").append(id);
        sb.append(", slNo=").append(slNo);
        sb.append(", type='").append(type).append('\'');
        sb.append(", inputType='").append(inputType).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", hint='").append(hint).append('\'');
        sb.append('}');
        return sb.toString();
    }
}