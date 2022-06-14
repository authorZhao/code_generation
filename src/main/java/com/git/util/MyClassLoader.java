package com.git.util;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader {
    private static MyClassLoader myClassLoader = null;
    private MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
        check();
    }

    synchronized private void check() {
        if(myClassLoader!=null){
            throw new RuntimeException();
        }
    }

    synchronized public static MyClassLoader instance(){
        if(myClassLoader==null){
            myClassLoader = new MyClassLoader();
        }
        return myClassLoader;
    }


    /**
     * 吧class数组转化为Class对象
     * @param name 类全名
     * @param data class数组
     * @return
     */
    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }

}
