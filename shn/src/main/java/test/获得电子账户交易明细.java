package test;

import cn.hutool.core.text.csv.CsvRow;
import entity.TradeDetail;
import util.MyCsvUtil;

import java.util.ArrayList;
import java.util.List;

public class 获得电子账户交易明细 {
    public static void main(String[] args) {
        String fileName = "201803.csv";
        List<CsvRow> rows = MyCsvUtil.getData(fileName);
        rows.remove(0);
        List<TradeDetail> tradeDetails = toTradeDetail(rows);
        StringBuilder stringBuilder = new StringBuilder();
        for (TradeDetail tradeDetail : tradeDetails) {
            String 主机流水号 = tradeDetail.get主机流水号();
            String 流水笔次 = tradeDetail.get流水笔次();
            String 开户机构 = tradeDetail.get开户机构();
            String 账户序号 = tradeDetail.get账户序号();
            String 账号 = tradeDetail.get账号();
            String 户名 = tradeDetail.get户名();
            String 产品编码 = tradeDetail.get产品编码();
            String 交易码 = tradeDetail.get交易码();
            String 增减标志 = tradeDetail.get增减标志();
            String 现转标志 = tradeDetail.get现转标志();
            String 交易金额 = tradeDetail.get交易金额();
            String 余额 = tradeDetail.get余额();
            String 交易日期 = tradeDetail.get交易日期();
            String 机器日期 = tradeDetail.get机器日期();
            String 交易时间 = tradeDetail.get交易时间();
            String 摘要代码 = tradeDetail.get摘要代码();
            String 摘要 = tradeDetail.get摘要();
            String 对方账号 = tradeDetail.get对方账号();
            String 对方名称 = tradeDetail.get对方名称();
            String 交易订单号 = tradeDetail.get交易订单号();
            String 明细状态 = tradeDetail.get明细状态();
            String 场景类型 = tradeDetail.get场景类型();
            String trade="";
            stringBuilder.append(trade);
        }
        MyCsvUtil.writFile(stringBuilder.toString(),fileName);
    }

    public static List<TradeDetail> toTradeDetail(List<CsvRow> rows) {
        List<TradeDetail> tradeDetails = new ArrayList<>(rows.size());
        for (CsvRow row : rows) {
            Object[] object = row.toArray();
            String 主机流水号 = object[0].toString().trim();
            String 流水笔次 = object[1].toString().trim();
            String 开户机构 = object[2].toString().trim();
            String 账户序号 = object[3].toString().trim();
            String 账号 = object[4].toString().trim();
            String 户名 = object[5].toString().trim();
            String 产品编码 = object[6].toString().trim();
            String 交易码 = object[7].toString().trim();
            String 增减标志 = object[8].toString().trim();
            String 现转标志 = object[9].toString().trim();
            String 交易金额 = object[10].toString().trim();
            String 余额 = object[11].toString().trim();
            String 交易日期 = object[12].toString().trim();
            String 机器日期 = object[13].toString().trim();
            String 交易时间 = object[14].toString().trim();
            String 摘要代码 = object[15].toString().trim();
            String 摘要 = object[16].toString().trim();
            String 对方账号 = object[17].toString().trim();
            String 对方名称 = object[18].toString().trim();
            String 交易订单号 = object[19].toString().trim();
            String 明细状态 = object[20].toString().trim();
            String 场景类型 = object[21].toString().trim();
            TradeDetail tradeDetail = new TradeDetail(主机流水号, 流水笔次, 开户机构, 账户序号, 账号, 户名, 产品编码, 交易码, 增减标志, 现转标志, 交易金额, 余额, 交易日期, 机器日期, 交易时间, 摘要代码, 摘要, 对方账号, 对方名称, 交易订单号, 明细状态, 场景类型);
            tradeDetails.add(tradeDetail);
        }
        return tradeDetails;
    }
}
