package util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;
import test.用户注册01;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class MyCsvUtil {

    public static List<CsvRow> getData(String fileName) {
/*        try {
            fileName = URLDecoder.decode(MyCsvUtil.class.getClassLoader().getResource(fileName).getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
      String localFile = "C:\\" + fileName;
//        String localFile = fileName;
        File file = FileUtil.file(localFile);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在：" + localFile);
        }
        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(file, /*CharsetUtil.CHARSET_UTF_8*/CharsetUtil.CHARSET_UTF_8);
        List<CsvRow> rows = data.getRows();
        return rows;
    }

    public static void writFile(String string, String fileName) {
        fileName=fileName.substring(0,fileName.lastIndexOf("."));
        String path = "c:\\" + fileName + ".sql";
        FileWriter writer = new FileWriter(path,CharsetUtil.CHARSET_UTF_8);
        writer.write(string);
        System.out.println("写入文件成功：" + path);
    }
    public static void writFile(String string, String fileName,String fileSuffix) {
        String path = "c:\\" + fileName + fileSuffix;
        FileWriter writer = new FileWriter(path,CharsetUtil.CHARSET_UTF_8);
        writer.write(string);
        System.out.println("写入文件成功：" + path);
    }

    public static void main(String[] args) {
        writFile("123", "1");
    }
}
