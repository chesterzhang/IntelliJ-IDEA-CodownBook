package processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerProcessor implements Processor  {

    @Override
    public void process(SourceBookData sourceBookData) throws IOException {
        Template template=getTemplate();
        Object model=getModel(sourceBookData);
        Writer writer =getWriter(sourceBookData);
        try {
            template.process(model,writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //返回一个HashMap 字典, 交给 freeMark 的 template 进行写入操作, 输出 markdown 文档
    protected Object getModel(SourceBookData sourceBookData) {
        Map<String,Object> model=new HashMap<>();
        model.put("Topic", sourceBookData.getTopic());
        model.put("BookData",sourceBookData.getBookData());
        return model;
    }

    //这个方法是 FreeMarker的, 照抄先, 先不管, 总之就是返回一个 FreeMarker的模板配置文件

    protected Template getTemplate() throws IOException {
        //加载freemarker模板字符串
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_29);

        //创建freemarker模板配置
        String templateContent= UrlUtil.loadText(FreeMarkerProcessor.class.getResource("/template/md.ftl"));

        //创建字符串模板的导入器
        StringTemplateLoader stringTemplateLoader=new StringTemplateLoader();

        //导入字符串模板
        stringTemplateLoader.putTemplate("MDTemplate",templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);

        //获取模板
        return configuration.getTemplate("MDTemplate");
    }

    //获取writer, 完成写入操作

    protected Writer getWriter(SourceBookData sourceBookData) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName=sourceBookData.getFileName();
        File file=new File(fileName);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
        return bufferedWriter;
    }
}


