package com.epam.testdata.xlsparser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class XLSParser<T> {


    private Class<T> clazz;

    private String path;

    private Map<String, Field> fieldMap;

    public XLSParser(Class<T> clazz, String path) {

        this.clazz = clazz;
        this.path = path;

        fieldMap = new HashMap<>();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(KeyLabel.class)) {
                fieldMap.put(field.getAnnotation(KeyLabel.class).value(), field);
            }
        }

    }


    public List<T> getAll() {

        List<T> result = new ArrayList<>();

        FileInputStream fis = null;

        try {

            fis = new FileInputStream(path);

            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();


            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            List<String> header = new ArrayList<>();

            while (cellIterator.hasNext()) {
                header.add(cellIterator.next().getStringCellValue());
            }

            while (rowIterator.hasNext()) {

                T t = clazz.newInstance();

                cellIterator = rowIterator.next().cellIterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();

                    int cellType = currentCell.getCellType();


                    Field field = fieldMap.get(header.get(currentCell.getColumnIndex()));


                    if (cellType == Cell.CELL_TYPE_STRING) {

                        field.set(t, currentCell.getStringCellValue());

                    } else if (cellType == Cell.CELL_TYPE_NUMERIC) {

                        if (field.getType().isAssignableFrom(Double.class))
                            field.set(t, currentCell.getNumericCellValue());

                        if (field.getType().isAssignableFrom(Integer.class))
                            field.set(t, (int) currentCell.getNumericCellValue());
                    }

                }

                result.add(t);
            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return result;

    }


}
