package entity;

public class EcifTemp {
    String 证件号;
    String 新的电子账户;
    String 新的客户号;
    String 介质账户ACC_ID;
    String 旧的电子账户;
    String 旧的客户号;
    String 证件类型;
    String 客户姓名;


    public String get证件号() {
        return 证件号;
    }

    public void set证件号(String 证件号) {
        this.证件号 = 证件号;
    }

    public String get新的电子账户() {
        return 新的电子账户;
    }

    public void set新的电子账户(String 新的电子账户) {
        this.新的电子账户 = 新的电子账户;
    }

    public String get新的客户号() {
        return 新的客户号;
    }

    public void set新的客户号(String 新的客户号) {
        this.新的客户号 = 新的客户号;
    }

    public EcifTemp() {
    }

    public String get介质账户ACC_ID() {
        return 介质账户ACC_ID;
    }

    public void set介质账户ACC_ID(String 介质账户ACC_ID) {
        this.介质账户ACC_ID = 介质账户ACC_ID;
    }

    public String get旧的电子账户() {
        return 旧的电子账户;
    }

    public void set旧的电子账户(String 旧的电子账户) {
        this.旧的电子账户 = 旧的电子账户;
    }

    public String get旧的客户号() {
        return 旧的客户号;
    }

    public void set旧的客户号(String 旧的客户号) {
        this.旧的客户号 = 旧的客户号;
    }


    public String get证件类型() {
        return 证件类型;
    }

    public void set证件类型(String 证件类型) {
        this.证件类型 = 证件类型;
    }

    public String get客户姓名() {
        return 客户姓名;
    }

    public void set客户姓名(String 客户姓名) {
        this.客户姓名 = 客户姓名;
    }

    public EcifTemp(String 证件号, String 新的电子账户, String 新的客户号, String 介质账户ACC_ID, String 旧的电子账户, String 旧的客户号, String 证件类型, String 客户姓名) {
        this.证件号 = 证件号;
        this.新的电子账户 = 新的电子账户;
        this.新的客户号 = 新的客户号;
        this.介质账户ACC_ID = 介质账户ACC_ID;
        this.旧的电子账户 = 旧的电子账户;
        this.旧的客户号 = 旧的客户号;
        this.证件类型 = 证件类型;
        this.客户姓名 = 客户姓名;
    }
}
