package com.FH.FactoryMethodPattern;

import java.util.List;
import java.util.Random;

public class HumanFactory {
    public static Human createHuman(Class c) {
        Human human = null;
        try {
//          Class.forName()获取的是类对象，然后通过newInstancce()来实例化，相当于human=new Human();
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("指定的类中有问题");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("指定的类不能实例化");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
            e.printStackTrace();
        }
        return human;
    }

    public static Human createHuman(){
        Human human=null;
//        根据接口找到所有的实现类
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        int i = random.nextInt(concreteHumanList.size());
        human= createHuman(concreteHumanList.get(i));
        return human;
    }
}
