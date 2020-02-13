package entity;

import java.util.Objects;

public class ECIF_RISK_INFO {
    private String 客户号,评估日期,评估等级;
    private String 客户名称,证件号,证件类型;

    public String get客户号() {
        return 客户号;
    }

    public void set客户号(String 客户号) {
        this.客户号 = 客户号;
    }

    public String get评估日期() {
        return 评估日期;
    }

    public void set评估日期(String 评估日期) {
        this.评估日期 = 评估日期;
    }

    public String get评估等级() {
        return 评估等级;
    }

    public void set评估等级(String 评估等级) {
        this.评估等级 = 评估等级;
    }

    public ECIF_RISK_INFO(String 客户号, String 评估日期, String 评估等级) {
        this.客户号 = 客户号;
        this.评估日期 = 评估日期;
        this.评估等级 = 评估等级;
    }

    public ECIF_RISK_INFO( ) {
        this.客户号 = 客户号;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ECIF_RISK_INFO that = (ECIF_RISK_INFO) o;
        return 客户号.equals(that.客户号);
    }

    @Override
    public int hashCode() {
        return Objects.hash(客户号);
    }

    public String get客户名称() {
        return 客户名称;
    }

    public void set客户名称(String 客户名称) {
        this.客户名称 = 客户名称;
    }

    public String get证件号() {
        return 证件号;
    }

    public void set证件号(String 证件号) {
        this.证件号 = 证件号;
    }

    public String get证件类型() {
        return 证件类型;
    }

    public void set证件类型(String 证件类型) {
        this.证件类型 = 证件类型;
    }
}
