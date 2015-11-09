package com.epam.control.elementimpl;

import com.epam.control.element.Table;
import com.epam.control.engine.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/9/2015.
 */
public class TableByColumns implements Table {

    private WebDriver driver;

    private List<List<WebElement>> webElementRows;

    public TableByColumns(String base, String... columnXPaths) {

        driver = WebDriverUtils.getDriver();

        webElementRows = new ArrayList<>();
         

        for (String columnXPath : columnXPaths) {
            webElementRows.add(driver.findElements(By.xpath(base + columnXPath)));
        }

    }


    @Override
    public int getRowsCount() {
        return 0;
    }

    @Override
    public int getColumnsCount() {
        return 0;
    }

    @Override
    public void clickOn(int row, int column) {
        webElementRows.get(column).get(row).click();
    }

    @Override
    public Object getElement(int row, int column) {
        return null;
    }

    @Override
    public TableImpl.Row getRow(int row) {
        return null;
    }

    @Override
    public List<TableImpl.Row> getAllRows() {
        return null;
    }
}
