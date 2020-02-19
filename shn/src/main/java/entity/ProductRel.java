package entity;

import java.util.Objects;

/**
 * 产品关系表（不在数据库中，作为中间数据使用）
 */
public class ProductRel {
    String 旧的产品编号;
    String 现在产品编号;
    String 产品名称;
    String 产品工厂编号;

    public String get旧的产品编号() {
        return 旧的产品编号;
    }

    public void set旧的产品编号(String 旧的产品编号) {
        this.旧的产品编号 = 旧的产品编号;
    }

    public String get现在产品编号() {
        return 现在产品编号;
    }

    public void set现在产品编号(String 现在产品编号) {
        this.现在产品编号 = 现在产品编号;
    }

    public String get产品名称() {
        return 产品名称;
    }

    public void set产品名称(String 产品名称) {
        this.产品名称 = 产品名称;
    }

    public String get产品工厂编号() {
        return 产品工厂编号;
    }

    public void set产品工厂编号(String 产品工厂编号) {
        this.产品工厂编号 = 产品工厂编号;
    }

    public ProductRel(String 旧的产品编号, String 现在产品编号, String 产品名称, String 产品工厂编号) {
        this.旧的产品编号 = 旧的产品编号;
        this.现在产品编号 = 现在产品编号;
        this.产品名称 = 产品名称;
        this.产品工厂编号 = 产品工厂编号;
    }

    public ProductRel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRel that = (ProductRel) o;
        return Objects.equals(旧的产品编号, that.旧的产品编号) &&
                Objects.equals(现在产品编号, that.现在产品编号) &&
                Objects.equals(产品名称, that.产品名称) &&
                Objects.equals(产品工厂编号, that.产品工厂编号);
    }

    @Override
    public int hashCode() {
        return Objects.hash(旧的产品编号, 现在产品编号, 产品名称, 产品工厂编号);
    }

    @Override
    public String toString() {
        return 产品名称+","+旧的产品编号+","+现在产品编号+","+产品工厂编号+"\n";
    }
}
