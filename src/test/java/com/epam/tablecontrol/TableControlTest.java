package com.epam.tablecontrol;

import com.epam.businesslogic.LoginService;
import com.epam.control.element.Table;
import com.epam.control.elementimpl.TableByColumns;
import com.epam.control.elementimpl.TableImpl;
import com.epam.testdata.Data;
import org.testng.annotations.Test;

/**
 * Created by Oleh_Maksymuk on 11/9/2015.
 */
public class TableControlTest {

    protected static final String MESSAGES_BOX_XPATH = "//div[@gh='tl']//tbody/tr";

    @Test
    public void test () {


        LoginService loginService = new LoginService(Data.getUserDataExсel());

        loginService.login();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Table table = new TableByColumns(
                MESSAGES_BOX_XPATH,
                "//div[@role='checkbox']",
                "//div[@class='pG']",
                "//span[@class='zF']",
                "//span[@class='y2']"
        );

        table.clickOn(0,0);

        table.clickOn(0,1);

        table.clickOn(1,0);

        table.clickOn(1,1);

    }

}
