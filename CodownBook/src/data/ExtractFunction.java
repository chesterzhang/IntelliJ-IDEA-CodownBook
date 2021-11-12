package data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.LinkedHashMap;
import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;

public class ExtractFunction {
    public ExtractFunction() {
    	super();
    }
  	
	public static String Extract(String targetSrc) {
		// (\\w+):匹配public/protected/private
		// (\\s+):匹配一个或多个空格
		// (\\w+):匹配返回值如void，String
		// (\\s+):匹配一个或多个空格
		// ([_a-zA-Z]+[_a-zA-Z0-9]*):匹配函数名
		// ([(]([^()]*)[)]):group(1) 匹配参数
		Pattern p = Pattern.compile("(\\s+)(\\w+)(\\s+)(\\w+)(\\s+)([_a-zA-Z]+[_a-zA-Z0-9]*)([(]([^()]*)[)])");  
		Matcher m = p.matcher((CharSequence) targetSrc);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String Json;
		while (m.find()) {
			Map<String, Object> maps = new LinkedHashMap<>();
			maps.put("FunctionAll", m.group(0).trim());
			maps.put("FunctionAccMod", m.group(2));
			maps.put("FunctionRetType", m.group(4));
			maps.put("FunctionName", m.group(6));
			maps.put("FunctionPara", StringUtils.strip(m.group(7),"()"));
			list.add(maps);
        }
		Json = JSON.toJSONString(list);
		return Json;
	}
}
