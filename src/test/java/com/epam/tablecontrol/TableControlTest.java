package com.epam.tablecontrol;

import com.epam.businesslogic.LoginService;
import com.epam.control.element.Table;
import com.epam.control.elementimpl.TableImpl;
import com.epam.testdata.Data;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by Oleh_Maksymuk on 11/9/2015.
 */
public class TableControlTest {

    protected static final String MESSAGES_BOX_XPATH = "//div[@gh='tl']//tbody/tr";

    @Test
    public void test() {


        LoginService loginService = new LoginService(Data.getUserDataExсel());

        loginService.login();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Table table = new TableImpl(

                MESSAGES_BOX_XPATH + "//div[@role='checkbox']",
                MESSAGES_BOX_XPATH + "//td[4]",
                MESSAGES_BOX_XPATH + "//td[5]",
                MESSAGES_BOX_XPATH + "//td[6]"

        );

        for (int i = 0; i < table.getRowsCount(); i++) {

            System.out.print(((WebElement)table.getElement(i, 0)).isSelected() + " ");
            System.out.print(((WebElement)table.getElement(i, 1)).isSelected() + " ");
            System.out.print(((WebElement)table.getElement(i, 2)).getText() + " ");
            System.out.println(((WebElement)table.getElement(i, 3)).getText());

            table.clickOn(i, 0);
            table.clickOn(i, 1);

            System.out.print(((WebElement)table.getElement(i, 0)).isSelected() + " ");
            System.out.print(((WebElement)table.getElement(i, 1)).isSelected() + " ");
            System.out.print(((WebElement)table.getElement(i, 2)).getText() + " ");
            System.out.println(((WebElement)table.getElement(i, 3)).getText());
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < table.getRowsCount(); i++) {
            table.clickOn(i, 0);
            table.clickOn(i, 1);
        }
    }

}
