package com.epam.control.element;

import com.epam.control.elementimpl.TableImpl;
import com.epam.control.marker.Decorable;

import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/9/2015.
 */
public interface Table {


    int getRowsCount();

    int getColumnsCount();

    void clickOn(int row, int column);

    Object getElement(int row, int column);

    TableImpl.Row getRow(int row);


    List<TableImpl.Row> getAllRows();


}
