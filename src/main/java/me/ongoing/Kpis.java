package me.ongoing;

import me.ongoing.easyexcel.model.Excel;

public class Kpis {

    @Excel(name="序号")
    private String id;

    @Excel(name="指标名称")
    private String name;

    @Excel(name="单位")
    private String unit;

    @Excel(name="指标规则")
    private String role;

    @Excel(name="时间维度")
    private String dim1;

    @Excel(name="空间维度")
    private String dim2;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDim1() {
        return dim1;
    }

    public void setDim1(String dim1) {
        this.dim1 = dim1;
    }

    public String getDim2() {
        return dim2;
    }

    public void setDim2(String dim2) {
        this.dim2 = dim2;
    }

    @Override
    public String toString() {
        return "Kpis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", role='" + role + '\'' +
                ", dim1='" + dim1 + '\'' +
                ", dim2='" + dim2 + '\'' +
                '}';
    }
}
