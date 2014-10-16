package com.bean.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;

public class BeanUtilsClient {
	public static void main(String[] args){
		Object bean = new UserDefined();
		System.out.println("Is Bean Blank??? "+isBeanBlank(bean));
		setBeanDefaults(bean);
		System.out.println("Is Bean Blank??? "+isBeanBlank(bean));
	}
	
	@SuppressWarnings("unchecked")
	public static boolean isBeanBlank(Object bean) {
		boolean isBlank = true;
		try{
			Map<String, String> map = BeanUtils.describe(bean);
			if (map != null) {
				for (String key : map.keySet()) {
					if ("class".equalsIgnoreCase(key) || "metaClass".equalsIgnoreCase(key)){
						continue;
					}
					PropertyUtilsBean pb = new PropertyUtilsBean();
					String propType = pb.getPropertyType(bean, key).getName();
					if (StringUtils.isNotBlank(map.get(key))) {
						if(propType.equals("int") || propType.equals("long") || propType.equals("float") || propType.equals("double")){
							Double double1 = new Double(map.get(key));
							if(double1 != 0){
								isBlank = false;
							}
						} else if(propType.equals("boolean")){
							boolean b1 = new Boolean(map.get(key));
							if(b1){
								isBlank = false;
							}
						}
					}
					System.out.println("key " + key + " type "+ propType +": value "+map.get(key));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isBlank;
	}
	
	@SuppressWarnings("unchecked")
	public static Object setBeanDefaults(Object bean){
		try{
			Map<String, String> map = BeanUtils.describe(bean);
			if (map != null) {
				for (String key : map.keySet()) {
					if ("class".equalsIgnoreCase(key) || "metaClass".equalsIgnoreCase(key)){
						continue;
					}
					if (StringUtils.isNotBlank(map.get(key))) {
						PropertyUtilsBean pb = new PropertyUtilsBean();
						String propType = pb.getPropertyType(bean, key).getName();
						if(propType.equals("int") || propType.equals("long") || propType.equals("float") || propType.equals("double")){
							Double double1 = new Double(map.get(key));
							if(double1 == 0){
								pb.setProperty(bean, key, 10);
							}
						} else if(propType.equals("boolean")){
							boolean b1 = new Boolean(map.get(key));
							if(b1){
								pb.setProperty(bean, key, true);
							}
						}
						//System.out.println("key " + key + " type "+ propType +": value "+map.get(key));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}
}
