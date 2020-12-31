package com.study.ioc.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//自定义Application
public class KaneClassPathXmlApplicationContext {
    //1.解析XML文件
    //2. 使用方法参数bean id查找bean节点的id是否一致
    //3.获取class信息地址，使用反射初始化
    //4. 标准化生产 beanDefinition （略过）
    //5. 找个map塞进去
    private String xmlPath;

   static Map<String,Object> singletonObjects = new ConcurrentHashMap<>(256);

   //1.首先实例化的时候，要传入一个路径（通过构造方法获取）
    public KaneClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

        public Object getbean(String id) throws Exception {
            if(id==null) throw  new IllegalArgumentException("id不能为空");
            if(singletonObjects.containsKey(id)) return singletonObjects.get(id);
            List<Element> readerXml = readerXML();
            if(readerXml==null) throw new Exception("配置文件啥都没有");
            String className = findByElementClass(readerXml,id);
            if(className==null)throw new Exception("配置文件找不到当前节点");

            return newInstance(className);
    }


    public String findByElementClass( List<Element> readerXml,String beanId) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        for (Element element : readerXml) {
            String xmlBeanId = element.attributeValue("id");
            if(beanId==xmlBeanId)
                continue; //也可以类名小写，自己实现.
            if(xmlBeanId.equals(beanId)){
                //先去map查，没有就创建
                String xmlClass = element.attributeValue("class");
                singletonObjects.put(beanId,newInstance(xmlClass)); //创建一个放入到map中
                return xmlClass;
            }

        }
      return null;
    }

   //自己写的一个反射功能
    public Object newInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(className);
        return aClass.newInstance();
    }

    public List<Element>  readerXML() throws DocumentException { //解析XML
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getResourceAsStream(xmlPath));//读取XML
        Element rootElement = document.getRootElement();
        List<Element> attributes = rootElement.elements();
        return attributes;

    }

    //获取上下文路径
    public InputStream getResourceAsStream(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }



}
