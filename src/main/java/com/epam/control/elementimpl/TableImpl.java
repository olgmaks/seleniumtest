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
public class TableImpl implements Table {

    private WebDriver driver;

    private List<List<WebElement>> webElementRows;

    public TableImpl(String... columnXPaths) {

        driver = WebDriverUtils.getDriver();

        webElementRows = new ArrayList<>();


        for (String columnXPath : columnXPaths) {
            webElementRows.add(driver.findElements(By.xpath(columnXPath)));
        }

    }


    @Override
    public int getRowsCount() {
        return webElementRows.get(0).size();
    }

    @Override
    public int getColumnsCount() {
        return webElementRows.size();
    }

    @Override
    public void clickOn(int row, int column) {
        ((WebElement) getElement(row, column)).click();
    }

    @Override
    public Object getElement(int row, int column) {
        return webElementRows.get(column).get(row);
    }





}
