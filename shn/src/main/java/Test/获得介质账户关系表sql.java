package Test;

import cn.hutool.core.text.csv.CsvRow;
import entity.Ecif;
import util.MyCSVUtil;

import java.util.ArrayList;
import java.util.List;

public class 获得介质账户关系表sql {
    public static void main(String[] args) {
        String fileName="获得介质账户关系表.csv";
        List<CsvRow> rows = MyCSVUtil.getData(fileName);
        rows.remove(0);
        List<Ecif> ecifs = toEcifList(rows);
        //获得介质账户关系表sql
        MyCSVUtil.writFile(getACCSql(ecifs),fileName);

    }
    //获得介质账户表MDM_ACC_REL的sql
    public static String getACCSql(List<Ecif> rows) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 41;
        String br_sign = "123";
        int VI_NO = 42847;
        int acc_id_start =82621;
        String acc_id_prefix="1000000";
        for (Ecif row : rows) {
            start = start + 1;
            acc_id_start=acc_id_start+1;
            String 客户编码 = "1" + br_sign + String.format("%08d", start);
            String 客户姓名 = row.get客户姓名();
            String 建立日期 = row.get客户手机银行注册日期();
            String 开户机构号 = "770000";
            String 手机号 = row.get手机号();
            String 证件类型 = row.get证件类型();
            String 证件号 = row.get证件号();
            String 电子账户=row.get该客户系统内唯一编号();
            String 账户状态=row.get账户状态();

            String ACC_ID=acc_id_prefix+acc_id_start;
            String MDM_ACC_REL = "INSERT INTO MDM_ACC_REL (\"OPN_BR_NO\", \"ACC_NO\", \"ACC_ID\", \"ACC_SEQN\", \"ACC_NAME\", \"CIF_NO\", \"MDM_CODE\", \"NOTE_NO\", \"MDM_STS\", \"COLL_STS\", \"REL_BEG_DATE\", \"REL_END_DATE\", \"PAY_USE_PWD_FLAG\", \"PAY_USE_CERT_FLAG\", \"CERT_TYPE\", \"CERT_NO\", \"PAY_USE_CIPHER_FLAG\", \"MDM_MAIN_FLAG\", \"MDM_MAC\", \"MDM_OPEN_FLAG\", \"MDM_IC_INFO\", \"MDM_EXT_STS\") " +
                    "VALUES ('"+开户机构号+"', '"+电子账户+"', '"+ACC_ID+"', '9999', '"+客户姓名+"', '"+客户编码+"', 'XN01', NULL, '"+账户状态+"', 'CS01', '"+建立日期+"', '99999999', 'UF01', 'UF00', '"+证件类型+"', '"+证件号+"', 'UF00', '9999', NULL, '01', NULL, NULL);\n";
            stringBuilder.append(MDM_ACC_REL);
        }
        return  stringBuilder.toString();
    }
    public static List<Ecif> toEcifList(List<CsvRow> rows) {
        List<Ecif> ecifs = new ArrayList<>(rows.size());
        for (CsvRow csvRow : rows) {
            Object[] object = csvRow.toArray();
            String 开户机构号 = object[0].toString().trim();
            String 流水号 = object[1].toString().trim();
            String 证件类型 = object[2].toString().trim();
            String 证件号 = object[3].toString().trim();
            String 客户姓名 = object[4].toString().trim();
            String 手机号 = object[5].toString().trim();
            String 身份证起始日期 = object[6].toString().trim();
            String 身份证有效结束日期 = object[7].toString().trim();
            String 身份证注册地 = object[8].toString().trim();
            String 客户手机银行注册日期 = object[9].toString().trim();
            String 注册时间 = object[10].toString().trim();
            String 电子账号 = object[11].toString().trim();
            String 账户性质 = object[12].toString().trim();
            String 账户状态 = object[13].toString().trim();
            String 开户渠道 = object[14].toString().trim();
            String 该客户系统内唯一编号 = object[15].toString().trim();
            String 是否身份核验 = object[16].toString().trim();

            Ecif ecif = new Ecif(开户机构号, 流水号, 证件类型, 证件号, 客户姓名, 手机号, 身份证起始日期, 身份证有效结束日期, 身份证注册地,
                    客户手机银行注册日期, 注册时间, 电子账号, 账户性质, 账户状态, 开户渠道, 该客户系统内唯一编号, 是否身份核验);
            ecifs.add(ecif);
        }
        return ecifs;
    }

}
