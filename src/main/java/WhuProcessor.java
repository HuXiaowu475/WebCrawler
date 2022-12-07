import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class WhuProcessor {
    public static void main(String[] args) throws IOException {
        String url1 = "http://cs.whu.edu.cn/teacher.aspx?showtype=department&typename=%e8%ae%a1%e7%ae%97%e6%9c%ba%e7%a7%91%e5%ad%a6%e7%b3%bb";
        String url2 = "http://cs.whu.edu.cn/teacher.aspx?showtype=department&typename=%e8%bd%af%e4%bb%b6%e5%b7%a5%e7%a8%8b%e7%b3%bb";
        String url3 = "http://cs.whu.edu.cn/teacher.aspx?showtype=department&typename=%e4%ba%ba%e5%b7%a5%e6%99%ba%e8%83%bd%e7%b3%bb";
        String url4 = "http://cs.whu.edu.cn/teacher.aspx?showtype=department&typename=%e5%85%ac%e5%85%b1%e8%af%be%e6%95%99%e5%ad%a6%e4%b8%ad%e5%bf%83";
        String url5 = "http://cs.whu.edu.cn/teacher.aspx?showtype=department&typename=%e5%ae%9e%e9%aa%8c%e6%95%99%e5%ad%a6%e4%b8%ad%e5%bf%83";
        Document doc1 = Jsoup.parse(new URL(url1),100000);
        Document doc2 = Jsoup.parse(new URL(url2),100000);
        Document doc3 = Jsoup.parse(new URL(url3),100000);
        Document doc4 = Jsoup.parse(new URL(url4),100000);
        Document doc5 = Jsoup.parse(new URL(url5),100000);
        String path = "E:\\WebCrawler\\";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("武汉大学计算机学院教师名录");
        int rowNumber = 0;
        int rowNumber2 = -1;
        int rowNumber3 = -1;
        int rowNumber4 = -1;
        int rowNumber5 = -1;
        HashSet<String> researchSet = new HashSet<>();
        List<Element> teacherList = new ArrayList<>();


        Elements elements1 = doc1.getElementsByTag("tr");
        for (Element e : elements1){
            String name = e.getElementsByClass("w1").eq(0).text();
            String gender = e.getElementsByClass("w2").eq(0).text();
            String post = e.getElementsByClass("w4").eq(0).text();
            String research = e.getElementsByClass("w5").eq(0).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(gender);
            cell3.setCellValue(post);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+gender+" "+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements2 = doc2.getElementsByTag("tr");
        for (Element e : elements2){
            String name = e.getElementsByClass("w1").eq(0).text();
            String gender = e.getElementsByClass("w2").eq(0).text();
            String post = e.getElementsByClass("w4").eq(0).text();
            String research = e.getElementsByClass("w5").eq(0).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }
            if(rowNumber2 < 0) {
                rowNumber2++;
                continue;
            }
            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(gender);
            cell3.setCellValue(post);
            cell4.setCellValue(research);

            rowNumber++;
            System.out.print(name+" "+"\t\t"+gender+" "+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements3 = doc3.getElementsByTag("tr");
        for (Element e : elements3){
            String name = e.getElementsByClass("w1").eq(0).text();
            String gender = e.getElementsByClass("w2").eq(0).text();
            String post = e.getElementsByClass("w4").eq(0).text();
            String research = e.getElementsByClass("w5").eq(0).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }
            if(rowNumber3 < 0) {
                rowNumber3++;
                continue;
            }
            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(gender);
            cell3.setCellValue(post);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+gender+" "+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements4 = doc4.getElementsByTag("tr");
        for (Element e : elements4){
            String name = e.getElementsByClass("w1").eq(0).text();
            String gender = e.getElementsByClass("w2").eq(0).text();
            String post = e.getElementsByClass("w4").eq(0).text();
            String research = e.getElementsByClass("w5").eq(0).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }
            if(rowNumber4 < 0) {
                rowNumber4++;
                continue;
            }
            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(gender);
            cell3.setCellValue(post);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+gender+" "+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements5 = doc5.getElementsByTag("tr");
        for (Element e : elements5){
            String name = e.getElementsByClass("w1").eq(0).text();
            String gender = e.getElementsByClass("w2").eq(0).text();
            String post = e.getElementsByClass("w4").eq(0).text();
            String research = e.getElementsByClass("w5").eq(0).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }
            if(rowNumber5 < 0) {
                rowNumber5++;
                continue;
            }
            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(gender);
            cell3.setCellValue(post);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+gender+" "+" "+"\t\t"+post+"\t\t"+research+"\n");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path + "武汉大学计算机学院教师名录.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        for (String a:researchSet) {
            System.out.println(a);
        }
        System.out.println("");
        System.out.println("");
        for(String str : researchSet){
            if(!str.equals("")){
                System.out.print(str + ":");
                for(Element e:teacherList){
                    String research = e.getElementsByClass("w5").eq(0).text();
                    String splitStr[] = research.split("、|,|，");
                    for(String str1 : splitStr){
                        if(str.equals(str1))
                            System.out.print(e.getElementsByClass("w1").eq(0).text()+" ");
                    }
                }
                System.out.println("");
            }

        }

    }

}