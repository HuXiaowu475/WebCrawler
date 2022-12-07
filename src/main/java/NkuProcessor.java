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


public class NkuProcessor {
    public static void main(String[] args) throws IOException {
        String url1 = "https://cc.nankai.edu.cn/jswyjy/list.htm";
        String url2 = "https://cc.nankai.edu.cn/fjswfyjy/list.htm";
        String url3 = "https://cc.nankai.edu.cn/js/list.htm";
        String url4 = "https://cc.nankai.edu.cn/syjxdw/list.htm";
        Document doc1 = Jsoup.parse(new URL(url1),100000);
        Document doc2 = Jsoup.parse(new URL(url2),100000);
        Document doc3 = Jsoup.parse(new URL(url3),100000);
        Document doc4 = Jsoup.parse(new URL(url4),100000);
        String path = "E:\\WebCrawler\\";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("南开大学计算机学院教师名录");
        int rowNumber = 0;
        HashSet<String> researchSet = new HashSet<>();
        List<Element> teacherList = new ArrayList<>();

        Elements elements1 = doc1.getElementsByTag("tr");
        for (Element e : elements1){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String major = e.getElementsByTag("td").eq(2).text();
            String research = e.getElementsByTag("td").eq(3).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，|；");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(major);
            cell4.setCellValue(research);

            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+major+"\t\t"+research+"\n");
        }
        Elements elements2 = doc2.getElementsByTag("tr");
        for (Element e : elements2){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String major = e.getElementsByTag("td").eq(2).text();
            String research = e.getElementsByTag("td").eq(3).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，|；");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(major);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+major+"\t\t"+research+"\n");
        }
        Elements elements3 = doc3.getElementsByTag("tr");
        for (Element e : elements3){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String major = e.getElementsByTag("td").eq(2).text();
            String research = e.getElementsByTag("td").eq(3).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，|；");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(major);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+major+"\t\t"+research+"\n");
        }
        Elements elements4 = doc4.getElementsByTag("tr");
        for (Element e : elements4){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String major = e.getElementsByTag("td").eq(2).text();
            String research = e.getElementsByTag("td").eq(3).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，|；");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            Cell cell4 = row.createCell(3);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(major);
            cell4.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+major+"\t\t"+research+"\n");
        }
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        Cell cell4 = row.createCell(3);
        cell1.setCellValue("姓名");
        cell2.setCellValue("职称");
        cell3.setCellValue("所属部门");
        cell4.setCellValue("研究方向");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "南开大学计算机学院教师名录.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("");
        System.out.println("");

        for(String str : researchSet){
            if(!str.equals("")){
                System.out.print(str + ":");
                for(Element e:teacherList){
                    String research = e.getElementsByTag("td").eq(3).text();
                    String splitStr[] = research.split("、|,|，|；");
                    for(String str1 : splitStr){
                        if(str.equals(str1))
                            System.out.print(e.getElementsByTag("td").eq(0).text()+" ");
                    }
                }
                System.out.println("");
            }

        }
    }

}
