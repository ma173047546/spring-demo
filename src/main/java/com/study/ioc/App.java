package com.study.ioc;

import com.study.ioc.aop.KaneAop;
import com.study.ioc.config.AppConfig;
import com.study.ioc.service.Index;
import com.study.ioc.service.UserService;
import com.study.ioc.service.impl.KaneServiceImpl;
import com.study.ioc.xml.KaneAnnotationApplication;
import com.study.ioc.xml.KaneClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//体验一下，Application的使用方式吧/
public class App {
    ApplicationContext applicationContext ;

    public static void main(String[] args) {
//        //就是在 ClassPath 中寻找 xml 配置文件，根据 xml 文件内容来构建 ApplicationContext
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//获取到容器上下文
//        //除了ClassPathXmlApplicationContext 以外，可在类图上找到其他的实现.
//        //本次 我们需要理解的是SpringIOC的核心流程--我们将类图进行简化 --如果在Springboot上看，类图会非常复杂。
//        //我们需要根据我们当前的状况 分析我们需要的是哪一个实现类，哪一个说明。这点非常重要.
//        //根据java的继承体系，我们会理解到一个非常重要的点，我们一般使用的 是最后那个子类。
//        //我们根据分支来简单了解下其他的最底层子类
//        //FileSystemXmlApplicationContext 的构造函数需要一个 xml 配置文件在系统中的路径
//        //AnnotationConfigApplicationContext 是基于注解来使用的，它不需要配置文件
//
//        System.out.println("IOC容器 构造成功");
//        UserService userService = (UserService)applicationContext.getBean("userService");
//        //当然我们也可以通过 类型来获取
//        UserService userService1 = applicationContext.getBean(UserService.class);
//        //一旦获取到之后，我们可以输出
//        String userName1 = userService1.getUserName();
//        String userName = userService.getUserName();
//        System.out.println("当前获取的bean为:"+userService+"调用方法为:"+userName);
//        System.out.println("当前获取的bean为"+userService1+"调用方法:"+userName);

        //如何通过配置文件 来启动Spring的ApplicationContext
        //ApplicationContext在启动过程中，会去读取xml中的bean 并创建bean实例，然后注入依赖.

//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        KaneAop userService = ac.getBean(KaneAop.class);
//        System.out.println(userService.getKane());
      

        //自定义的XML
        KaneClassPathXmlApplicationContext classPathXmlApplicationContext =new KaneClassPathXmlApplicationContext("applicationContext.xml");
        try {
            Object getbean = classPathXmlApplicationContext.getbean("userSerivce");
            System.out.println(getbean);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        KaneAnnotationApplication annotationApplication = new KaneAnnotationApplication();
//        KaneServiceImpl kaneServiceImpl = (KaneServiceImpl)annotationApplication.getBean("kaneServiceImpl");
//        System.out.println(kaneServiceImpl);
//        kaneServiceImpl.test();

    }
}
