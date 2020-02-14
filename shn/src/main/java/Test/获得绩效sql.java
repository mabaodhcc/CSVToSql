package Test;

import cn.hutool.core.text.csv.CsvRow;
import entity.JiXiao;
import entity.TradeDetail;
import util.MyCSVUtil;

import java.util.ArrayList;
import java.util.List;

public class 获得绩效sql {
    public static void main(String[] args) {
        String fileName = "绩效.csv";
        List<CsvRow> rows = MyCSVUtil.getData(fileName);
        rows.remove(0);
        List<JiXiao> jiXiaos = toJiXiao(rows);
        StringBuilder stringBuilder = new StringBuilder();
        for (JiXiao jixiao:jiXiaos) {
            String  开户机构编码=jixiao.get开户机构编码();
            String  客户号=jixiao.get客户号();
            String  电子账号=jixiao.get电子账号();
            String  账户序号=jixiao.get账户序号();
//            提供的csv数据缺少ACC_ID这个列
            String ACC_ID="未设置ACC_ID";
            String  是否关联客户经理标志=jixiao.get是否关联客户经理标志();
            String  客户经理客户号= jixiao.get客户经理客户号();
            String  客户经理编号=jixiao.get客户经理编号();
            String  客户经理名=jixiao.get客户经理名();
            String  产品编号=jixiao.get产品编号();
            //绩效 ACC_MANGE_REL账户客户经理关联表
            String ACC_MANGE_REL="INSERT INTO ACC_MANGE_REL (\"OPN_BR_NO\", \"CIF_NO\", \"ACC_NO\", \"ACC_ID\", \"ACC_SEQN\", \"CIF_MANGE_REL\", \"MANGE_CIF\", \"MANGE_NO\", \"MANGE_NAME\", \"PRDT_NO\") " +
                    " VALUES ('"+开户机构编码+"', '"+客户号+"', '"+电子账号+"', '"+ACC_ID+"', '"+账户序号+"', '"+是否关联客户经理标志+"', "+客户经理客户号+", '"+客户经理编号+"', '"+客户经理名+"', '"+产品编号+"');\n";
            stringBuilder.append(ACC_MANGE_REL);
        }
        MyCSVUtil.writFile(stringBuilder.toString(),fileName);
    }
    public static List<JiXiao> toJiXiao(List<CsvRow> rows){
        List list=new ArrayList<JiXiao>(rows.size());
        for (CsvRow row:
             rows) {
            Object [] object=row.toArray();
            JiXiao  jiXiao=new JiXiao(object[0].toString().trim(),object[1].toString().trim(),object[2].toString().trim(),object[3].toString().trim(),object[4].toString().trim(),object[5].toString().trim(),object[6].toString().trim(),object[7].toString().trim(),object[8].toString().trim());
            list.add(jiXiao);
        }
        return list;
    }
}
