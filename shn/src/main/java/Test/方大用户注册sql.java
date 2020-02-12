package Test;

import cn.hutool.core.text.csv.CsvRow;
import entity.Ecif;
import util.MyCSVUtil;

import java.util.ArrayList;
import java.util.List;

public class 方大用户注册sql {
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

    public static void main(String[] args) {
        String fileName="过渡电子账户部分客户信息.csv";
        List<CsvRow> rows = MyCSVUtil.getData(fileName);
        rows.remove(0);
        List<Ecif> ecifs = toEcifList(rows);
//        String sql = getSQL(ecifs);
        //电子账户注册信息表sql
//        System.out.println(getACCSql(ecifs));
        MyCSVUtil.writFile(getACCSql(ecifs),fileName);
    }

    public static String getSQL(List<Ecif> rows) {
        StringBuilder stringBuilder = new StringBuilder();
        int start = 41;
        String br_sign = "123";
        int VI_NO = 42847;
        for (Ecif row : rows) {
            start = start + 1;
            String 客户编码 = "1" + br_sign + String.format("%08d", start);
            String 客户姓名 = row.get客户姓名();
            String 建立日期 = row.get客户手机银行注册日期();
            String 开户机构号 = "770000";
            String 手机号 = row.get手机号();
            String 证件类型 = row.get证件类型();
            String 证件号 = row.get证件号();
            String 登录密码 = "d41d8cd98f00b204e9800998ecf8427e";
            // 注册时间 ECIF_LOGIN_INFO
            String 注册时间 = row.get客户手机银行注册日期() + row.get注册时间();
            String 上次登录号码 = "123";
            String 上次登录时间 = 注册时间;

            // 注册时间 ECIF_VEDIO_INFO
            String VI_PATH = "未设置";
            String VI_UP_DATE = row.get客户手机银行注册日期();
            String VI_UP_TIME = row.get注册时间();
            String VI_UP_DEVICE = "未设置";

            //ECIF_BASE_INFO
            String ECIF_BASE_INFO = "INSERT INTO ECIF_BASE_INFO (\"CIF_NO\", \"CIF_CN_NAME\", \"CIF_EN_NAME\", \"CIF_PY_NAME\", \"CIF_SN_NAME\", \"CIF_TYPE\", \"CIF_LOCAL_FLAG\", \"CIF_POTEN_FLAG\", \"CIF_EMP_FLAG\", \"CIF_STOCK_FLAG\", \"CIF_LVL\", \"CIF_CRED_LVL\", \"CIF_INFO\", \"CIF_STS\", \"CIF_CTB_LVL\", \"CIF_RISK_LVL\", \"CIF_RISK_ALERT_SIG\", \"CIF_LVL_MOD_TYPE\", \"CIF_LVL_WARN_NUM\", \"CIF_ADD_INFO1\", \"CIF_ADD_INFO2\", \"CIF_CRT_BR_NO\", \"CIF_CRT_OPER\", \"CIF_CRT_DATE\", \"CIF_MOD_DATE\", \"BR_NO\") " +
                    "VALUES ('" + 客户编码 + "', '" + 客户姓名 + "', NULL, NULL, NULL, 'CT01', 'LF00', NULL, 'EF00', NULL, 'LV01', 'CL01', NULL, 'CS00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '" + 建立日期 + "', NULL, '" + 开户机构号 + "');\n";

            //ECIF_LOGIN_INFO
            String ECIF_LOGIN_INFO = "INSERT INTO ECIF_LOGIN_INFO (\"LOGIN_NAME\", \"PHONE_NO\", \"CERT_TYPE\", \"CERT_NO\", \"CIF_EMAIL\", \"PWD_GPWD_FLAG\", \"PWD_GPWD\", \"PWD_GPWD_ERR_CNT\", \"PWD_GPWD_ERR_TIME\", \"PWD_LOGIN\", \"PWD_LOGIN_ERR_CNT\", \"PWD_LOGIN_ERR_TIME\", \"REG_DATE\", \"LAST_LOGIN_MODE\", \"LAST_LOGIN_NO\", \"LAST_LOGIN_TIME\", \"LAST_LOGOUT_TIME\", \"LOGIN_CHNL_CODE\", \"LOGIN_IP\", \"LOGIN_DEVICE\", \"LOGIN_DESC\", \"LOGIN_STS\", \"BR_NO\", \"USER_ID\")" +
                    " VALUES ('" + 客户姓名 + "', '" + 手机号 + "', '" + 证件类型 + "', '" + 证件号 + "', NULL, NULL, NULL, NULL, NULL, '" + 登录密码 + "', NULL, NULL, '" + 注册时间 + "', NULL, '" + 上次登录号码 + "', '" + 上次登录时间 + "', NULL, NULL, NULL, NULL, NULL, NULL, '" + 开户机构号 + "', NULL);\n";

            //ECIF_VEDIO_INFO
            //每个用户需要插入3条数据的
            StringBuilder ECIF_VEDIO_INFO = new StringBuilder();
            for (int i = 1; i <= 3; i++) {
                VI_NO = VI_NO + 1;
                VI_PATH = "未设置";
                VI_PATH = VI_PATH + i;
                String VI_NAME = null;
                if (i == 1) {
                    VI_NAME = "cert_front";
                } else if (i == 2) {
                    VI_NAME = "cert_hand";
                } else if (i == 3) {
                    VI_NAME = "cert_reverse";
                }
                String item = "INSERT INTO ECIF_VEDIO_INFO (\"VI_NO\", \"CIF_NO\", \"CIF_ACT\", \"VI_PATH\", \"VI_TYPE\", \"VI_SIZE\", \"VI_UP_DATE\", \"VI_UP_TIME\", \"VI_OPER\", \"VI_VALID_DATE\", \"VI_UP_DEVICE\", \"VI_STS\", \"VI_NAME\", \"BR_NO\", \"CERT_TYPE\", \"CERT_NO\") " +
                        "VALUES ('" + VI_NO + "', '" + 客户编码 + "', 'CA01', '" + VI_PATH + "', 'VT00', NULL, '" + VI_UP_DATE + "', '" + VI_UP_TIME + "', NULL, '29991230', '" + VI_UP_DEVICE + "', 'VS00', '" + VI_NAME + "', '" + 开户机构号 + "', '" + 证件类型 + "', '" + 证件号 + "');\n";
                ECIF_VEDIO_INFO.append(item);
            }

            //ECIF_CERT_INFO
            String 身份证起始日期 = row.get身份证起始日期();
            String 身份证有效结束日期 = row.get身份证有效结束日期();
            String 身份证注册地 = row.get身份证注册地();
            String ECIF_CERT_INFO = "INSERT INTO ECIF_CERT_INFO (\"CIF_NO\", \"CERT_TYPE\", \"CERT_NO\", \"CERT_NAME\", \"CERT_DESC\", \"CERT_LIC\", \"CERT_CHK\", \"CERT_NET_FLAG\", \"CERT_SUPT\", \"CERT_MAIN_FLAG\", \"CERT_STS\", \"CERT_BEG_DATE\", \"CERT_END_DATE\", \"CERT_LAST_DATE\", \"BR_NO\")" +
                    " VALUES ('" + 客户编码 + "', '" + 证件类型 + "', '" + 证件号 + "', '" + 客户姓名 + "', NULL, '" + 身份证注册地 + "', 'CC00', 'NF01', 'CS00', 'MF01', 'CS00', '" + 身份证起始日期 + "', '" + 身份证有效结束日期 + "', NULL, '" + 开户机构号 + "');\n";

            //ECIF_PER_INFO
            String ECIF_PER_INFO = "INSERT INTO ECIF_PER_INFO(\"CIF_NO\", \"PER_NAT_CODE\", \"PER_LIVE_CODE\", \"PER_LANG_CODE\", \"PER_RACE_CODE\", \"PER_SUN_BIRTH\", \"PER_MOON_BIRTH\", \"PER_SEX\", \"PER_EDU\", \"PER_RELI\", \"PER_CATA\", \"PER_PROF\", \"PER_DUTY\", \"PER_TITLE\", \"PER_INCOME\", \"PER_HOME_INCOME\", \"PER_MARRY\", \"PER_MARRY_DATE\", \"PER_FARMER\") " +
                    "VALUES ('" + 客户编码 + "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);\n";

            //ECIF_PHOTO_INFO
            String ECIF_PHOTO_INFO = "INSERT INTO ECIF_PHOTO_INFO (\"CIF_NO\", \"CIF_PHOTO\", \"CIF_BIG_PHOTO\", \"CIF_UP_DATE\", \"CIF_UP_TIME\", \"BR_NO\") " +
                    "VALUES ('" + 客户编码 + "', NULL, NULL, '" + 建立日期 + "', '" + row.get注册时间() + "', '" + 开户机构号 + "');\n";
            String ECIF_PER_CONT_INFO = "INSERT INTO ECIF_PER_CONT_INFO (\"CIF_NO\", \"CONT_HOME_ADDR\", \"CONT_NOW_ADDR\", \"CONT_POST\", \"CONT_HOME_PHONE\", \"CONT_PHONE\", \"CONT_HOME_FAX\", \"CONT_URL\", \"CONT_EMAIL\", \"CONT_QQ\", \"CONT_SKYPE\", \"CONT_MSN\", \"CONT_WECHAT\", \"CONT_BLOG\", \"CONT_ALIAS\") " +
                    "VALUES ('" + 客户编码 + "', NULL, NULL, NULL, NULL, '" + 手机号 + "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);\n";
            String ECIF_PWD_INFO = "INSERT INTO ECIF_PWD_INFO (\"CIF_NO\", \"PWD_SEC_LVL\", \"PWD_CHNG_INTE\", \"PWD_PAY_LAST_DATE\", \"PWD_QUERY_LAST_DATE\", \"PWD_PAY_ERR_CNT\", \"PWD_QUERY_ERR_CNT\", \"PWD_ERR_TOL_CNT\", \"PWD_DESC\") " +
                    "VALUES ('" + 客户编码 + "', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);\n";

            stringBuilder.append(ECIF_BASE_INFO)
                    .append(ECIF_LOGIN_INFO)
                    .append(ECIF_VEDIO_INFO)
                    .append(ECIF_CERT_INFO)
                    .append(ECIF_PER_INFO)
                    .append(ECIF_PHOTO_INFO)
                    .append(ECIF_PER_CONT_INFO)
                    .append(ECIF_PWD_INFO)
                    .append("\n");
            stringBuilder.append("UPDATE ECIF_NO_CTL set cif_no_seqn = '" + start + "' where br_no = '770000' and cif_type = 'CT01';");
        }
        return stringBuilder.toString();
    }

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
}