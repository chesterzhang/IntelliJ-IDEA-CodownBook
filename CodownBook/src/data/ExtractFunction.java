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
		// (\\w+):Match public/protected/private
		// (\\s+):Match one or more spaces
		// (\\w+):Match return value, such as void，String
		// (\\s+):Match one or more spaces
		// ([_a-zA-Z]+[_a-zA-Z0-9]*):Match function name
		// ([(]([^()]*)[)]):group(1):Matching parameters
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
