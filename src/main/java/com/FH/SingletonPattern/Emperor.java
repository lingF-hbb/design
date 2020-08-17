package com.FH.SingletonPattern;

public class Emperor {
    private static Emperor emperor=null;

    private Emperor(){};

    public static Emperor getInstance(){
        if(emperor==null){
            emperor=new Emperor();
        }
        return emperor;
    }

    public static void say(){
        System.out.println("这个皇帝市");
    }
}
