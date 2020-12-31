package com.study.ioc.xml;

import com.study.ioc.App;
import com.study.ioc.annotation.KaneComponent;
import com.study.ioc.util.ClassUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//利用注解注入到容器中
public class KaneAnnotationApplication {
   //思路一样， 需要一个map
    //通过扫描注解 (扫包操作) 反射一个类
    //没有id，所以需要获取到类名，转成id
    // 注入到map中
   static Map<String,Object> singletonObjects = new ConcurrentHashMap<>(256);

    public KaneAnnotationApplication(){

    }

    public Object getBean(String id){
        if(singletonObjects.containsKey(id)) {
            return singletonObjects.get(id);
        }else{
            return doCreateBean();
        }
    }

    public Object doCreateBean(){
        //1.扫包，扫描启动类下的包 -- 可以加入xml 标签指定路径 --可以直接指定启动类,这样需要进一步解析
        try {
            List<Class<?>> classes = ClassUtil.getAllClassByPackageName(App.class.getPackage());
            for (Class<?> aClass : classes) { //遍历启动类下的所有class对象，获取到带注解的这个bean
                KaneComponent annotation = aClass.getAnnotation(KaneComponent.class);
                if(annotation==null) continue;
                //一旦找到了这个类，获取它的名字
                String name = aClass.getName();
                //尽量简单 --
                String id = name.substring(0,1).toLowerCase()+name.substring(1);
                Object instance = aClass.newInstance();
                singletonObjects.put(id,instance);
                return instance;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


}
