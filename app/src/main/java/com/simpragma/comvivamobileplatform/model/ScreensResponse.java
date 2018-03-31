package com.simpragma.comvivamobileplatform.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScreensResponse {

    @SerializedName("rows")
    private List<ScreenRow> rows;

    public List<ScreenRow> getRows() {
        return rows;
    }

    public void setRows(List<ScreenRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScreensResponse{");
        sb.append("rows=").append(rows);
        sb.append('}');
        return sb.toString();
    }
}