package com.FH.FactoryMethodPattern;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;

public class ClassUtils {
//    方法参数：给一个接口，返回该接口的所有实现类
    public static List<Class> getAllClassByInterface(Class c){
        List<Class> returnClassList = new ArrayList<>();

//        如果不是一个接口，则不做处理
        if(c.isInterface()){
//            获得接口的包名
            Package aPackage = c.getPackage();
            System.out.println(aPackage);
            System.out.println(c.getName());
            String packName = c.getPackage().getName();
            try{
//              获得当前包及其子包的所有类
                List<Class> allClass=getClasses(packName);

//              判断是否是和传进来的接口是一个，如果是不加入集合
                for(int i=0;i<allClass.size();i++){
//                    A.isAssignableFrom(B)：判断B是否是A的子类或者子接口
                    if(c.isAssignableFrom(allClass.get(i))){
//                        c是传进来的接口，c接口不加入返回的list集合
                        if(!c.equals(allClass.get(i))){
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return returnClassList;
    }
// 从包中查找到所有的类，在jar包中的不用查找
    public static List<Class> getClasses(String packageName) throws ClassNotFoundException,IOException{
        System.out.println("包名"+packageName);
        ClassLoader ClassLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = ClassLoader.getResources(path);
        System.out.println("URL"+resources);
        List<File> dirs = new ArrayList<>();
//        resources.hasMoreElements():如果还有元素，就继续
        while (resources.hasMoreElements()){
            URL resource = resources.nextElement();
            System.out.println("uurrll"+resource);
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory:dirs
             ) {
            classes.addAll(findClasses(directory,packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File direcotry,String packageName)
    throws ClassNotFoundException{
        System.out.println(direcotry+""+packageName);
        ArrayList<Class> classes = new ArrayList<>();
        if(!direcotry.exists()){
            return classes;
        }
//        listFiles()方法返回的是某个目录下所有文件和目录的绝对路径，返回的是file数组
//        list()方法返回的某个目录中的文件和目录的名称 所组成de字符串抽象数组
        File[] files = direcotry.listFiles();
        for (File file:files
             ) {
            if(file.isDirectory()){
//                assert:断言
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName+"."+file.getName()));
            }else if(file.getName().endsWith(".class")){
                classes.add(Class.forName(packageName+'.'+file.getName().substring(0,file.getName().length()-6)));
            }
        }
        return classes;
    }





}
