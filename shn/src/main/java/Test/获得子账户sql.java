package Test;

import cn.hutool.core.text.csv.CsvRow;
import entity.Ecif;
import entity.SubAccount;
import util.MyCSVUtil;

import java.util.ArrayList;
import java.util.List;

public class 获得子账户sql {
    public static void main(String[] args) {
        String fileName="子账户.csv";
        List<CsvRow> list =MyCSVUtil.getData(fileName);
        list.remove(0);
        List<SubAccount> subAccounts=toSubAccount(list);
        StringBuilder stringBuilder=new StringBuilder();
        for (SubAccount subAccount: subAccounts) {
            //后面需要修改真是数据，暂时前4列就先直接从csv里面取值
            //ACC_id
            String 内部账号="123";
//            "AG_ACC_NO",就是电子账户
            String 内部账号序号=subAccount.get电子账号();
            //"AG_ACC_SEQN",
            String 账卡号="123";
//            ACC_SEQN
            String 账户序号=subAccount.get账户序号();

            String 合作机构代码="770000";
            String 利率=subAccount.get利率();
            String 起息日期=subAccount.get起息日();
            String 产品号=subAccount.get产品号();
            String 账户余额=subAccount.get账户余额();
            String 最后动账日=subAccount.get最后动账日();
            String 透支标志=subAccount.get透支标志();
            String 账户状态=subAccount.get账户状态();
            String 止付状态=subAccount.get止付状态();
            String 冻结状态=subAccount.get冻结状态();
            String 上笔发生日期="1111111111";
            String 累计收益=subAccount.get累计收益();
            String 预计收益=subAccount.get预计收益();
            String 提现标识=subAccount.get提现标识();
            String 开户时间=subAccount.get签约日期();//只要日期部分
            String 冻结金额=subAccount.get冻结金额();
            String 止付金额=subAccount.get止付金额();
            String 控制金额=subAccount.get控制金额();
            String 结息日期=subAccount.get终止日();
            String 开通标志="0000000000";
            String 客户号="";
            String 账户类型="AT01";
            String 明细笔数="0";
            String DE_MST="INSERT INTO  DE_MST (\"ACC_ID\", \"AG_ACC_NO\", \"AG_ACC_SEQN\", \"ACC_SEQN\", \"OPN_BR_NO\", \"AG_BR_NO\", \"PRDT_NO\", \"CUR_NO\", \"DE_BAL\", \"DE_BOOK_BAL\", \"DE_YS_BAL\", \"DE_RATE\", " +
                    "\"DE_HST_CNT\", \"DE_OPN_DATE\", \"DE_IC_DATE\", \"DE_LAST_DATE\", \"DE_MTR_DATE\", \"DE_ACC_STS\", \"DE_HOLD_STS\", \"DE_HOLD_AMT\", \"DE_STOP_PAY_STS\", \"DE_STOP_PAY_AMT\", \"DE_CTL_AMT\", \"DE_OD_FLAG\", \"DE_CIF_NO\", \"DE_OPEN_FLAG\"," +
                    " \"DE_MAC\", \"DE_INTS_DATE\", \"DE_CIF_LAST_DATE\", " +
                    "\"DE_RATE_TYPE\", \"DE_CASH_FLAG\", \"DE_ACC_TYPE\", \"DE_INTST\", \"DE_UNPAY_INTST\", \"DE_AMT1\", \"DE_AMT2\")\n" +
                    " VALUES ('"+内部账号+"', '"+内部账号序号+"', '"+账卡号+"', '"+账户序号+"', '"+合作机构代码+"', '"+合作机构代码+"', '"+产品号+"', '156', '"+账户余额+"', '0', '0', '"+利率+"', " +
                    "'"+明细笔数+"', '"+开户时间+"', '"+起息日期+"', '"+上笔发生日期 +"', '99991231', '"+账户状态+"', '"+冻结状态+"', '"+冻结金额+"', '"+止付状态+"', '"+止付金额+"', '"+控制金额+"', '"+透支标志+"', " +
                    "'"+客户号+"', '"+开通标志+"', NULL, '"+结息日期+"', '"+最后动账日+"', 'RT00', '"+提现标识+"', '"+账户类型+"', " +
                    "'"+累计收益+"', NULL, NULL, NULL);\n";
            stringBuilder.append(DE_MST);
        }
        //子账户表
//        System.out.println(stringBuilder);
        MyCSVUtil.writFile(stringBuilder.toString(),fileName);
    }

    public static List<SubAccount> toSubAccount(List<CsvRow> rows) {
        List<SubAccount> subAccounts=new ArrayList<SubAccount>(rows.size());
        for (CsvRow csvRow : rows) {
            Object[] object = csvRow.toArray();
            String 客户号 = object[0].toString().trim();
            String 电子账号 = object[1].toString().trim();
            String 账户序号 = object[2].toString().trim();
            String 产品号 = object[3].toString().trim();
            String 开户时间 = object[4].toString().trim();
            String 起息日 = object[5].toString().trim();
            String 终止日 = object[6].toString().trim();
            String 上次结息日 = object[7].toString().trim();
            String 产品名称 = object[8].toString().trim();
            String 账户余额 = object[9].toString().trim();
            String 冻结状态 = object[10].toString().trim();
            String 冻结金额 = object[11].toString().trim();
            String 止付状态 = object[12].toString().trim();
            String 止付金额 = object[13].toString().trim();
            String 控制金额 = object[14].toString().trim();
            String 利率 = object[15].toString().trim();
            String 积数 = object[16].toString().trim();
            String 最后动账日 = object[17].toString().trim();
            String 累计收益 = object[18].toString().trim();
            String 预计收益 = object[19].toString().trim();
            String 透支标志 = object[20].toString().trim();
            String 开户利率 = object[21].toString().trim();
            String 账户状态 = object[22].toString().trim();
            String 提现标识 = object[23].toString().trim();
            String 签约状态 = object[24].toString().trim();
            String 客户经理 = object[25].toString().trim();
            String 签约日期 = object[26].toString().trim();
            String 开户金额 = object[27].toString().trim();
            String 开户渠道 = object[28].toString().trim();

            SubAccount subAccount=new SubAccount(客户号,电子账号,账户序号,产品号,开户时间,起息日,终止日,
                    上次结息日,产品名称,账户余额,冻结状态,冻结金额,止付状态,止付金额,控制金额,
                    利率,积数,最后动账日,累计收益,预计收益,透支标志,
                    开户利率,账户状态,提现标识,签约状态,客户经理,签约日期,
                    开户金额,开户渠道);
            subAccounts.add(subAccount);
        }
        return subAccounts;
    }
}
