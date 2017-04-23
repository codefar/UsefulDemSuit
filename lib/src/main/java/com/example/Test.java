package com.example;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        //获取所有变量的值
        Class clazz = Class.forName("com.example.ScoreTable");
        Field[] fields = clazz.getFields();

        for( Field field : fields ){
            System.out.println( field.getName() + " " +field.getInt(clazz) );
        }

        //获取单个变量的值
        /*Class clazz = Class.forName("com.qianmingxs.ScoreTable");
        Field field = clazz.getField("FIVE");
        System.out.println( field.getInt(clazz));*/
    }

}