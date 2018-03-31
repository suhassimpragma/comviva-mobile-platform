package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StylesResponse {

    @SerializedName("rows")
    private List<StyleRow> rows;

    public List<StyleRow> getRows() {
        return rows;
    }

    public void setRows(List<StyleRow> rows) {
        this.rows = rows;
    }
}