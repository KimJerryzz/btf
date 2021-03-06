package kr.or.btf.web.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelParseHelper {
    private static String filepath;
    @Value("${Globals.fileStorePath}")
    private void setValue(String value){
        filepath = value;
    }

    private static String filepathURI;
    @Value("${Globals.fileStoreUriPath}")
    private void setValues(String values){
        filepathURI = values;
    }
/*
    public List<GroupPeople> parseExcelToGourpPeople(Long grpPid, AttachFile attachFile) throws IOException {
        List<GroupPeople> rtnList = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filepath + File.separator + Constants.FOLDERNAME_GROUP + File.separator + attachFile.getFlNm());
            int pos = attachFile.getFlNm().lastIndexOf( "." );
            String ext = attachFile.getFlNm().substring( pos + 1 );
            if ("xls".equals(ext)) {
                rtnList = parseXlsToGroupPeople(grpPid, fis);
            } else if ("xlsx".equals(ext)) {
                rtnList = parseXlsxToGroupPeople(grpPid, fis);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (fis != null) fis.close();
        }
        return rtnList;
    }

    private List<GroupPeople> parseXlsToGroupPeople(Long grpPid, FileInputStream fis) throws IOException {
        List<GroupPeople> rtnList = new ArrayList<GroupPeople>();
        GroupPeople groupPeople = null;
        HSSFWorkbook workbook =new HSSFWorkbook(fis);
        //?????? ??? (??????????????? ??????????????? 0??? ??????)
        //?????? ??? ????????? ?????????????????? FOR?????? ????????? ????????????
        HSSFSheet sheet = workbook.getSheetAt(0);
        //?????? ???
        int rows = sheet.getPhysicalNumberOfRows();
        for (int rowindex = 1; rowindex < rows; rowindex++) {
            groupPeople = new GroupPeople();
            groupPeople.setGrpPid(grpPid);
            //?????? ?????????
            HSSFRow row = sheet.getRow(rowindex);
            if (row != null){
                //?????? ???
                int cells = row.getPhysicalNumberOfCells();
                for (int columnindex = 0; columnindex <= cells; columnindex++) {
                    //????????? ?????????
                    HSSFCell cell = row.getCell(columnindex);
                    String value = "";
                    //?????? ?????????????????? ?????? ?????????
                    if (cell==null) {
                        continue;
                    } else {
                        //???????????? ?????? ??????
                        switch (cell.getCellType()) {
                            case FORMULA:
                                value = cell.getCellFormula();
                                break;
                            case NUMERIC:
                                value = cell.getNumericCellValue()+"";
                                break;
                            case STRING:
                                value = cell.getStringCellValue()+"";
                                break;
                            case BOOLEAN:
                                value = cell.getBooleanCellValue()+"";
                                break;
                            case ERROR:
                                value = cell.getErrorCellValue()+"";
                                break;
                            default:
                                value = "";
                        }
                        groupPeople = setValue(groupPeople, columnindex, value);
                    }
                }
            }
            rtnList.add(groupPeople);
        }
        return rtnList;
    }

    private List<GroupPeople> parseXlsxToGroupPeople(Long grpPid, FileInputStream fis) throws IOException {
        List<GroupPeople> rtnList = new ArrayList<GroupPeople>();
        GroupPeople groupPeople = null;
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //?????? ??? (??????????????? ??????????????? 0??? ??????)
        //?????? ??? ????????? ?????????????????? FOR?????? ????????? ????????????
        XSSFSheet sheet = workbook.getSheetAt(0);
        //?????? ???
        int rows = sheet.getPhysicalNumberOfRows();
        for (int rowindex = 1; rowindex < rows; rowindex++) {
            groupPeople = new GroupPeople();
            groupPeople.setGrpPid(grpPid);
            //???????????????
            XSSFRow row = sheet.getRow(rowindex);
            if (row != null) {
                //?????? ???
                int cells = row.getPhysicalNumberOfCells();
                for (int columnindex = 0; columnindex <= cells; columnindex++) {
                    //????????? ?????????
                    XSSFCell cell = row.getCell(columnindex);
                    String value = "";
                    //?????? ?????????????????? ?????? ?????????
                    if (cell == null) {
                        continue;
                    } else {
                        //???????????? ?????? ??????
                        switch (cell.getCellType()) {
                            case FORMULA:
                                value = cell.getCellFormula();
                                break;
                            case NUMERIC:
                                value = cell.getNumericCellValue()+"";
                                break;
                            case STRING:
                                value = cell.getStringCellValue()+"";
                                break;
                            case BOOLEAN:
                                value = cell.getBooleanCellValue()+"";
                                break;
                            case ERROR:
                                value = cell.getErrorCellValue()+"";
                                break;
                            default:
                                value = "";
                        }
                        groupPeople = setValue(groupPeople, columnindex, value);
                    }
                }
            }
            rtnList.add(groupPeople);
        }
        return rtnList;
    }

    private GroupPeople setValue(GroupPeople groupPeople, int index, String value) {
        switch (index) {
            case 0:
                groupPeople.setNm(value);
                break;
            case 1:
                groupPeople.setHpNum(StringHelper.onlyNumber(value));
                break;
            case 2:
                groupPeople.setEmail(value);
                break;
            case 3:
                groupPeople.setOfficeNm(value);
                break;
            case 4:
                groupPeople.setDeptNm(value);
                break;
            case 5:
                groupPeople.setPositionNm(value);
                break;
            case 6:
                groupPeople.setOfficeTelNum(StringHelper.onlyNumber(value));
                break;
        }
        return groupPeople;
    }*/
}
