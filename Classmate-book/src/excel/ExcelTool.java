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

public class ExcelTool {
	public void outExcel(List<users> ls) {
		HSSFWorkbook wb = null;
		String sheetName = "У��¼";
		String []title = new String[10];
		title[0]="ѧ��";
		title[1]="����";
		title[2]="��ͥסַ";
		title[3]="�绰";
		title[4]="΢��";
		title[5]="����";
		title[6]="QQ";
		title[7]="��������";
		title[8]="ְ��";
		title[9]="�༶";
		// ��һ��������һ��HSSFWorkbook����Ӧһ��Excel�ļ�
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // �ڶ�������workbook������һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // ����������sheet�����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������
        HSSFRow row = sheet.createRow(0);

        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

        //�����ж���
        HSSFCell cell = null;

        //��������
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //��������
        for(int i=0;i<ls.size();i++){
            row = sheet.createRow(i + 1);
            
            //for(int j=0;j<values[i].length;j++){
                //�����ݰ�˳�򸳸���Ӧ���ж���
                //row.createCell(j).setCellValue(values[i][j]);
            //}
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
        File file=new File("У��¼.xls");
        try { file.createNewFile();
            //��excelд��
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