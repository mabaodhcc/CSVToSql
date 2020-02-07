package Test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;
import entity.Grade;
import entity.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static List<Student> getStudents(String fileName)  {
        String localFile = "C:\\" + fileName;
        File file = FileUtil.file(localFile);
        if (!file.exists()){
            throw  new RuntimeException("文件不存在："+localFile);
        }
        CsvReader reader = CsvUtil.getReader();

        CsvData data = reader.read(file, CharsetUtil.CHARSET_UTF_8);

        List<CsvRow> rows = data.getRows();
        if (CollectionUtil.isEmpty(rows)){
            return null;
        }
        Object[] rowTitle = rows.get(0).toArray();
        rows.remove(0);
        List<Student> students = new ArrayList<>();
        for (CsvRow csvRow : rows) {
            Object[] row = csvRow.toArray();
            String id = row[0].toString().trim();
            String name = row[1].toString().trim();
            Student student = new Student(name, id);
            ArrayList<Grade> grades = new ArrayList<Grade>();
            for (int i = 2; i <= 7; i++) {
                grades.add(new Grade(id, rowTitle[i].toString().trim(), Double.valueOf(row[i].toString().trim())));
            }
            student.setGrades(grades);
            students.add(student);
        }
        return students;
    }

    public static void main(String[] args) {
        String fileName = "1.csv";
        List<Student> students = getStudents(fileName);
        if (CollectionUtil.isEmpty(students)){
            System.out.println("没有数据");
            return;
        }
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("数据输出完毕");
        System.out.println("程序说明:");
        System.out.println("    1、本程序是maven版本apache-maven-3.6.2,JDK 1.8,CSV文件操作通过第三方工具Hutool进行操作实现\n" +
                           "    2、输出结果以学生总成绩由高到低顺序列输出,当学生成绩相同时,则以学号升序进行排序");
        System.out.println("感谢您花时间阅读我的程序,期待有机会和您一起共事!");
        System.out.println("制作人：邵海楠,电话：15319109070,面试java开发工程师!");
    }
}
