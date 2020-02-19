package entity;

public class Product {

    //    渠道
    private String chnnl;

    //    产品名称
    private String prdtName;
    private String 存款类型;
    //互金产品编号
    private String prdtNo;
    //    工厂产品编号
    private String gcNo;
    //        分类
    private String 产品类型;
    //        存款期
    private String de_term;
    //        存款期单位
    private String de_termUnit;
    //        最低起存金额
    private String opn_min_amt;
    //        发售期
    private String fashouqi;
    //发售期单位
    private String fashouqiUnit;
    //        利率
    private String rate;
    //      计息规则
    private String rule;
    //        递增金额
    private String opn_unit_amt;
    //        是否可自动转存
    private String tfr_lmt_type;
    //        是否可部分提前支取
    private String draw_type;
    //机构编号
    private String brNo;

    public Product() {

    }

    public String getChnnl() {
        return chnnl;
    }

    public void setChnnl(String chnnl) {
        this.chnnl = chnnl;
    }

    public String getPrdtName() {
        return prdtName;
    }

    public void setPrdtName(String prdtName) {
        this.prdtName = prdtName;
    }

    public String get产品类型() {
        return 产品类型;
    }

    public void set产品类型(String 产品类型) {
        this.产品类型 = 产品类型;
    }

    public String getDe_term() {
        return de_term;
    }

    public void setDe_term(String de_term) {
        this.de_term = de_term;
    }

    public String getOpn_min_amt() {
        return opn_min_amt;
    }

    public void setOpn_min_amt(String opn_min_amt) {
        this.opn_min_amt = opn_min_amt;
    }

    public String getFashouqi() {
        return fashouqi;
    }

    public void setFashouqi(String fashouqi) {
        this.fashouqi = fashouqi;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getOpn_unit_amt() {
        return opn_unit_amt;
    }

    public void setOpn_unit_amt(String opn_unit_amt) {
        this.opn_unit_amt = opn_unit_amt;
    }

    public String getTfr_lmt_type() {
        return tfr_lmt_type;
    }

    public void setTfr_lmt_type(String tfr_lmt_type) {
        this.tfr_lmt_type = tfr_lmt_type;
    }

    public String getDraw_type() {
        return draw_type;
    }

    public void setDraw_type(String draw_type) {
        this.draw_type = draw_type;
    }

    public Product(String chnnl, String prdtName, String prdtNo, String gcNo, String fenlei, String de_term, String de_termUnit, String opn_min_amt, String fashouqi, String fashouqiUnit, String rate, String rule, String opn_unit_amt, String tfr_lmt_type, String draw_adva_flag, String brNo) {
        this.chnnl = chnnl;
        this.prdtName = prdtName;
        this.prdtNo = prdtNo;
        this.gcNo = gcNo;
        this.产品类型 = fenlei;
        this.de_term = de_term;
        this.de_termUnit = de_termUnit;
        this.opn_min_amt = opn_min_amt;
        this.fashouqi = fashouqi;
        this.fashouqiUnit = fashouqiUnit;
        this.rate = rate;
        this.rule = rule;
        this.opn_unit_amt = opn_unit_amt;
        this.tfr_lmt_type = tfr_lmt_type;
        this.draw_type = draw_adva_flag;
        this.brNo = brNo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "chnnl='" + chnnl + '\'' +
                ", prdtName='" + prdtName + '\'' +
                ", prdtNo='" + prdtNo + '\'' +
                ", gcNo='" + gcNo + '\'' +
                ", fenlei='" + 产品类型 + '\'' +
                ", de_term='" + de_term + '\'' +
                ", de_termUnit='" + de_termUnit + '\'' +
                ", opn_min_amt='" + opn_min_amt + '\'' +
                ", fashouqi='" + fashouqi + '\'' +
                ", fashouqiUnit='" + fashouqiUnit + '\'' +
                ", rate='" + rate + '\'' +
                ", rule='" + rule + '\'' +
                ", opn_unit_amt='" + opn_unit_amt + '\'' +
                ", tfr_lmt_type='" + tfr_lmt_type + '\'' +
                ", draw_adva_flag='" + draw_type + '\'' +
                ", brNo='" + brNo + '\'' +
                '}';
    }

    public String getBrNo() {
        return brNo;
    }

    public void setBrNo(String brNo) {
        this.brNo = brNo;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String getPrdtNo() {
        return prdtNo;
    }

    public void setPrdtNo(String prdtNo) {
        this.prdtNo = prdtNo;
    }

    public String getDe_termUnit() {
        return de_termUnit;
    }

    public void setDe_termUnit(String de_termUnit) {
        this.de_termUnit = de_termUnit;
    }

    public String getFashouqiUnit() {
        return fashouqiUnit;
    }

    public void setFashouqiUnit(String fashouqiUnit) {
        this.fashouqiUnit = fashouqiUnit;
    }

    public String get存款类型() {
        return 存款类型;
    }

    public void set存款类型(String 存款类型) {
        this.存款类型 = 存款类型;
    }
}
