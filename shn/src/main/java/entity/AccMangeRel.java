package entity;

/**
 *  ACC_MANGE_REL账户客户经理关联表
 */
public class AccMangeRel {
    private  String 开户机构编码,客户号,电子账号,账户序号,是否关联客户经理标志,客户经理客户号,客户经理编号,客户经理名,产品编号;

    public String get开户机构编码() {
        return 开户机构编码;
    }

    public void set开户机构编码(String 开户机构编码) {
        this.开户机构编码 = 开户机构编码;
    }

    public String get客户号() {
        return 客户号;
    }

    public void set客户号(String 客户号) {
        this.客户号 = 客户号;
    }

    public String get电子账号() {
        return 电子账号;
    }

    public void set电子账号(String 电子账号) {
        this.电子账号 = 电子账号;
    }

    public String get账户序号() {
        return 账户序号;
    }

    public void set账户序号(String 账户序号) {
        this.账户序号 = 账户序号;
    }

    public String get是否关联客户经理标志() {
        return 是否关联客户经理标志;
    }

    public void set是否关联客户经理标志(String 是否关联客户经理标志) {
        this.是否关联客户经理标志 = 是否关联客户经理标志;
    }

    public String get客户经理客户号() {
        return 客户经理客户号;
    }

    public void set客户经理客户号(String 客户经理客户号) {
        this.客户经理客户号 = 客户经理客户号;
    }

    public String get客户经理编号() {
        return 客户经理编号;
    }

    public void set客户经理编号(String 客户经理编号) {
        this.客户经理编号 = 客户经理编号;
    }

    public String get客户经理名() {
        return 客户经理名;
    }

    public void set客户经理名(String 客户经理名) {
        this.客户经理名 = 客户经理名;
    }

    public String get产品编号() {
        return 产品编号;
    }

    public void set产品编号(String 产品编号) {
        this.产品编号 = 产品编号;
    }

    public AccMangeRel(String 开户机构编码, String 客户号, String 电子账号, String 账户序号, String 是否关联客户经理标志, String 客户经理客户号, String 客户经理编号, String 客户经理名, String 产品编号) {
        this.开户机构编码 = 开户机构编码;
        this.客户号 = 客户号;
        this.电子账号 = 电子账号;
        this.账户序号 = 账户序号;
        this.是否关联客户经理标志 = 是否关联客户经理标志;
        this.客户经理客户号 = 客户经理客户号;
        this.客户经理编号 = 客户经理编号;
        this.客户经理名 = 客户经理名;
        this.产品编号 = 产品编号;
    }
    public AccMangeRel(){

    }
}
