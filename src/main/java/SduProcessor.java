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


public class SduProcessor {
    public static void main(String[] args) throws IOException {
        String url1 = "https://www.cs.sdu.edu.cn/szdw1/js.htm";
        String url2 = "https://www.cs.sdu.edu.cn/szdw1/yjy.htm";
        String url3 = "https://www.cs.sdu.edu.cn/szdw1/fjs.htm";
        String url4 = "https://www.cs.sdu.edu.cn/szdw1/zljs.htm";
        Document doc1 = Jsoup.parse(new URL(url1),100000);
        Document doc2 = Jsoup.parse(new URL(url2),100000);
        Document doc3 = Jsoup.parse(new URL(url3),100000);
        Document doc4 = Jsoup.parse(new URL(url4),100000);
        String path = "E:\\WebCrawler\\";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("山东大学计算机学院教师名录");
        int rowNumber = 0;
        HashSet<String> researchSet = new HashSet<>();
        List<Element> teacherList = new ArrayList<>();

        Elements elements1 = doc1.getElementsByTag("tr");
        for (Element e : elements1){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String research = e.getElementsByTag("td").eq(2).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements2 = doc2.getElementsByTag("tr");
        for (Element e : elements2){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String research = e.getElementsByTag("td").eq(2).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements3 = doc3.getElementsByTag("tr");
        for (Element e : elements3){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String research = e.getElementsByTag("td").eq(2).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Elements elements4 = doc4.getElementsByTag("tr");
        for (Element e : elements4){
            String name = e.getElementsByTag("td").eq(0).text();
            String post = e.getElementsByTag("td").eq(1).text();
            String research = e.getElementsByTag("td").eq(2).text();
            teacherList.add(e);
            String splitStr[] = research.split("、|,|，");
            for (String res:splitStr) {
                researchSet.add(res);
            }

            Row row = sheet.createRow(rowNumber);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue(name);
            cell2.setCellValue(post);
            cell3.setCellValue(research);
            rowNumber++;
            System.out.print(name+" "+"\t\t"+post+"\t\t"+research+"\n");
        }
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        cell1.setCellValue("姓名");
        cell2.setCellValue("职称");
        cell3.setCellValue("研究方向");

        FileOutputStream fileOutputStream = new FileOutputStream(path + "山东大学计算机学院教师名录.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();


        for(String str : researchSet){
            if(!str.equals("")){
                System.out.print(str + ":");
                for(Element e:teacherList){
                    String research = e.getElementsByTag("td").eq(2).text();
                    String splitStr[] = research.split("、|,|，");
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
