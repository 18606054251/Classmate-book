package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import model.Users;
public class ExcelTool {
	public static void outExcel(List<Users> ls) {
		HSSFWorkbook wb = null;
		String sheetName = "校友录";
		String []title = new String[10];
		title[0]="学号";
		title[1]="姓名";
		title[2]="家庭住址";
		title[3]="电话";
		title[4]="微信";
		title[5]="邮箱";
		title[6]="QQ";
		title[7]="个性语言";
		title[8]="职务";
		title[9]="班级";
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        HSSFSheet sheet = wb.createSheet(sheetName);

       
        HSSFRow row = sheet.createRow(0);

       
        HSSFCellStyle style = wb.createCellStyle();
       

        
        HSSFCell cell = null;

       
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        
        for(int i=0;i<ls.size();i++){
            row = sheet.createRow(i + 1);
            
           
            int j=0;
            row.createCell(j++).setCellValue(ls.get(i).getUsno());
            row.createCell(j++).setCellValue(ls.get(i).getUsname());
            row.createCell(j++).setCellValue(ls.get(i).getUsaddress());
            row.createCell(j++).setCellValue(ls.get(i).getUstele());
            row.createCell(j++).setCellValue(ls.get(i).getUsweixin());
            row.createCell(j++).setCellValue(ls.get(i).getUsyouxiangadd());
            row.createCell(j++).setCellValue(ls.get(i).getUsqq());
            row.createCell(j++).setCellValue(ls.get(i).getUsdiy());
            row.createCell(j++).setCellValue(ls.get(i).getUspost());
            row.createCell(j++).setCellValue(ls.get(i).getUcname());
        }
        File file=new File("鏍″弸褰�.xls");
        try { file.createNewFile();
            
            FileOutputStream stream= new FileOutputStream(file);
            wb.write(stream);
            stream.close();
        } catch (IOException e) { e.printStackTrace();}
        try {
			wb.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
        
    
	}
}
