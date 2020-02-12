package util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.util.List;

public class MyCSVUtil {
    public static List<CsvRow> getData(String fileName) {
        String localFile = "C:\\" + fileName;
        File file = FileUtil.file(localFile);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在：" + localFile);
        }
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(file, /*CharsetUtil.CHARSET_UTF_8*/CharsetUtil.CHARSET_GBK);
        List<CsvRow> rows = data.getRows();
        return rows;
    }

    public static void writFile(String string,String fileName ){
        String path="c:\\SQL\\"+fileName+".sql";
        FileWriter writer = new FileWriter(path);
        writer.write(string);
        System.out.println("写入文件成功："+path);
    }

    public static void main(String[] args) {
        writFile("123","1");
    }
}
