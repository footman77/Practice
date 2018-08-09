package beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
       // t1();


    }

    private static void t1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Student s = new Student();
        s.setId(1);
        s.setName("张三");
        s.setGender(true);
        s.setScore(88.8);
        s.setBirth(new Date());


        Object s2 = Class.forName("beanutils.Student").newInstance();

        ConvertUtils.register(new MyDateConvert(),Date.class);


        BeanUtils.copyProperty(s2,"brith","2015/01/01");
        System.out.println(s2);
    }
}

class MyDateConvert implements Converter{

    
    @Override
    public Object convert(Class src, Object value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            if(src==Date.class){
                String date = (String)value;
                Date curDate = sdf.parse(date);
                return curDate;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
}
