package com.first.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType; 

public class xmlUtils {

	public static HashMap<String,Locator> readElementInfo(String filePath){
//		String xfp=System.getProperty("user.dir")+"/webelementdata"+fileName;

		//		String xfp="C:\\Users\\lenovo\\workspace\\xulan.UItest\\webelementdata\\LoginPage.xml";
		//目标提取xml里面的数据，存入一个map
		Map<String,Locator> elementinfos=new HashMap<String,Locator>();
		//读取xml文件
		SAXReader saxReader=new SAXReader();
		Document document;
		try {
			document = saxReader.read(new File(filePath));
			//获取根节点
			Element root=document.getRootElement();
			//获取子节点
			List<Element> childList=root.elements("locator");
			for(Element e:childList){
				String name=e.attributeValue("name").toString();
//				ByType byType=getType(e.attributValue("type"));
				String type=e.attributeValue("type").toString();
				String value=e.attributeValue("value").toString();
				int timeOut=Integer.parseInt(e.attributeValue("timeout").trim());
		
				Locator locator=new Locator(name,getType(type),value,timeOut);
				String keyName=e.getText();
				elementinfos.put(keyName, locator);
			}
		} catch (DocumentException e1) {
		
			e1.printStackTrace();
		}
		
		return (HashMap<String,Locator>) elementinfos;
	}
	
	public static ByType getType(String value){
		ByType type=null;
		switch(value){
		case "css":
			type=ByType.cssSelector;
			break;
		case "xpath":
			type=ByType.xpath;
			break;
		}
		return type;
	}
	
}
