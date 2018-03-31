package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Style {

    @SerializedName("properties")
    private List<Property> properties;

    @SerializedName("type")
    private String type;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Style{");
        sb.append("properties=").append(properties);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}