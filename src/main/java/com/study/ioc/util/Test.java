package com.study.ioc.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws DocumentException {
        new Test().test1();
    }
    
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();  //1.解析xml(使用的lom4j)
        Document document = saxReader.read(getResourceAsStream("applicationContext.xml"));//读取XML
       //读取根节点 --也就是换成document(3.获取xml的根节点)
        Element rootElement = document.getRootElement();
        getNodes(rootElement);

    }

    public void getNodes( Element rootElement){ //开启递归
        System.out.println("获取节点名称:"+rootElement.getName());
        List<Attribute> attributes = rootElement.attributes(); //4.获取节点的泛型
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName()+"----"+attribute.getText());
        }
        //获取val
        String textTrim = rootElement.getTextTrim();
        if(StringUtils.isEmpty(textTrim)){
            System.out.println(textTrim);
        }
        //开启迭代
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()){
            Element element = elementIterator.next();
            getNodes(element);//自己迭代自己
        }
    }

    //将地址转换为流模式
    public InputStream getResourceAsStream(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;

    }
}
