package com.epam.control.elementimpl;

import com.epam.control.element.Table;
import com.epam.control.engine.WebDriverUtils;
import com.epam.control.marker.Decorable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/9/2015.
 */
public class TableImpl implements Table, Decorable {

    private WebDriver driver = WebDriverUtils.getDriver();

    private List<Row> rows ;

    private List<WebElement> webElementRows;


    public TableImpl(String xpathToTableRows, String... columnXPaths) {

        webElementRows = driver.findElements(By.xpath(xpathToTableRows));

        rows = new ArrayList<>();

        webElementRows.forEach(webElement -> {

            rows.add(new Row(webElement, columnXPaths));

        });

    }




    @Override
    public int getRowsCount() {
        return webElementRows.size();
    }

    @Override
    public int getColumnsCount() {
        return 0;
    }

    @Override
    public void clickOn(int row, int column) {
        rows.get(row).columns.get(column).click();
    }

    @Override
    public Object getElement(int row, int column) {
        return null;
    }

    @Override
    public Row getRow(int row) {
        return null;
    }

    @Override
    public List<Row> getAllRows() {
        return null;
    }


    public class Row {

        protected List<WebElement> columns;

        public Row(WebElement row, String... columnsXpaths) {

            columns = new ArrayList<>();

            for (String columnXpath : columnsXpaths) {
                columns.add(row.findElement(By.xpath(columnXpath)));
            }

//            System.out.println(row + columns.toString());

        }

    }


}
