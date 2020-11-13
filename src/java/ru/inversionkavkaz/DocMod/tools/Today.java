
package ru.inversionkavkaz.DocMod.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Today {

    public static java.util.Date getToday() throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String str = format.format(new java.util.Date());
        return format.parse(str);
    }     
}
