package com.FH.MultitionPattern;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
//      最大实例数
    private static final int maxnum=2;
//    皇帝名字集合
    private static ArrayList emperorInfoList=new ArrayList(maxnum);
//    皇帝对象列表
    private static ArrayList emperorList=new ArrayList(maxnum);
//    当前皇帝
    private static int countNumOfEmperor=0;

    static {
        for (int i=0;i<maxnum;i++){
            emperorList.add(new Emperor("皇"+(i+1)+"帝"));
        }
    }

    private Emperor(){}

    private Emperor(String info){
        emperorInfoList.add(info);
    }

    public static Emperor getInstance(){
        Random random = new Random();
        int countNumOfEmperor = random.nextInt(maxnum);
        return (Emperor)emperorList.get(countNumOfEmperor);
    }

    public static void nowname(){
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }

}
