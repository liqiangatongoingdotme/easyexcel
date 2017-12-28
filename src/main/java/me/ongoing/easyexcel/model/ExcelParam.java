package me.ongoing.easyexcel.model;

public class ExcelParam {

    private int titleRowNum;

    private int beginRow;

    private int endRow;

    public int getTitleRowNum() {
        return titleRowNum;
    }

    public void setTitleRowNum(int titleRowNum) {
        this.titleRowNum = titleRowNum;
    }

    public int getBeginRow() {
        return beginRow;
    }

    public void setBeginRow(int beginRow) {
        this.beginRow = beginRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public ExcelParam(int titleRowNum, int beginRow, int endRow) {
        this.titleRowNum = titleRowNum;
        this.beginRow = beginRow;
        this.endRow = endRow;
    }
}
