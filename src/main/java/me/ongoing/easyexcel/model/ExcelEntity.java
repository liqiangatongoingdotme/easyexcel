package me.ongoing.easyexcel.model;

public class ExcelEntity {

    private String name;

    private String fieldName;

    private String exportFormat;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExportFormat() {
        return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "ExcelEntity{" +
                "name='" + name + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", exportFormat='" + exportFormat + '\'' +
                '}';
    }
}
