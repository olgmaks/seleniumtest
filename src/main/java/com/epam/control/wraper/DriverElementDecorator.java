package com.epam.control.wraper;

import com.epam.control.marker.Decorable;
import com.epam.control.wraper.WebElementWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class DriverElementDecorator extends DefaultFieldDecorator {


    protected ElementLocatorFactory factory;

    public DriverElementDecorator(ElementLocatorFactory factory) {
        super(factory);
        this.factory = factory;
    }


    @Override
    public Object decorate(ClassLoader loader, Field field) {


        if (!(Decorable.class.isAssignableFrom(field.getType())
                || isDecoratableList(field))) {
            return null;

        }



        ElementLocator locator = factory.createLocator(field);

        if (locator == null) {
            return null;
        }

        if (Decorable.class.isAssignableFrom(field.getType())) {

            return new WebElementWrapper(proxyForLocator(loader, locator));

        } else if (List.class.isAssignableFrom(field.getType())) {

            List<Decorable> elementsProxies = new ArrayList<>();

            for (WebElement webEl : proxyForListLocator(loader, locator)) {
                elementsProxies.add(new WebElementWrapper(webEl));
            }

            return elementsProxies;
        } else {
            return null;
        }

    }

    @Override
    protected boolean isDecoratableList(Field field) {

//        System.out.println("isDecoratableList(Field field) : " + field);

        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        // Type erasure in Java isn't complete. Attempt to discover the generic
        // type of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return false;
        }

        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

        if (!Decorable.class.equals(listType)) {
            return false;
        }

        if (field.getAnnotation(FindBy.class) == null &&
                field.getAnnotation(FindBys.class) == null &&
                field.getAnnotation(FindAll.class) == null) {
            return false;
        }

        return true;
    }



}

