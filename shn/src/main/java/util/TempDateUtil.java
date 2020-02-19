package util;

import cn.hutool.core.text.csv.CsvRow;
import entity.EcifTemp;
import entity.ProductRel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TempDateUtil {
    private static HashMap<String,EcifTemp> ecifTempHashMap=new HashMap<>();
//    private static List<EcifTemp> ecifTemps = new ArrayList<>();
    private static  HashMap<String, ProductRel> productRels =new HashMap<>();

    public static HashMap<String,EcifTemp> getEcifTemps() {
        if (ecifTempHashMap.size() > 0) {
            return ecifTempHashMap;
        }
        String fileName = "客户信息中间表.csv";
        List<CsvRow> rows = MyCsvUtil.getData(fileName);
        rows.remove(0);
        return toEcifTemp(rows);
    }

    public static HashMap<String, EcifTemp> toEcifTemp(List<CsvRow> rows) {
        for (CsvRow row : rows) {
            Object[] object = row.toArray();
            String 证件号=object[0].toString().trim();
            String 新的电子账户=object[1].toString().trim();
            String 新的客户号=object[2].toString().trim();
            String 介质账户ACC_ID=object[3].toString().trim();
            String 旧的电子账户=object[4].toString().trim();
            String 旧的客户号=object[5].toString().trim();
            String 证件类型=object[5].toString().trim();
            String 客户姓名=object[5].toString().trim();

            EcifTemp ecifTemp=new EcifTemp(证件号, 新的电子账户, 新的客户号,介质账户ACC_ID,旧的电子账户,旧的客户号,证件类型,客户姓名);
            ecifTempHashMap.put(证件号,ecifTemp);
        }
        return ecifTempHashMap;
    }

    public static  HashMap<String, ProductRel> getProductRels() {
        if (productRels.size()>0){
            return productRels;
        }
        String fileName = "数据库里的产品关系表.csv";
        List<CsvRow> rows = MyCsvUtil.getData(fileName);
        rows.remove(0);
        return  toProductRels(rows);
    }

    public static HashMap<String, ProductRel> toProductRels(List<CsvRow> rows) {
        for (CsvRow row : rows) {
            Object[] object = row.toArray();
            String 现在产品编号 = object[0].toString().trim();
            String 产品工厂编号 = object[1].toString().trim();
            String 产品名称 = object[2].toString().trim();
            ProductRel productRel=new ProductRel("", 现在产品编号, 产品名称, 产品工厂编号);
            productRels.put(产品名称,productRel);
        }
        return productRels;
    }


}
