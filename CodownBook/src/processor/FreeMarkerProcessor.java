package processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// FreeMarker handles CodownBook
public class FreeMarkerProcessor implements Processor  {

    @Override
    public void process(SourceBookData sourceBookData) throws IOException {
        Template template=getTemplate();// Get FreeMarker template
        Object model=getModel(sourceBookData);// Build a model with sourceBookData
        Writer writer =getWriter(sourceBookData);// Get a writer object
        try {
            template.process(model,writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Return a HashMap dictionary, give it to FreeMark's template for writing, and output the markdown document
    protected Object getModel(SourceBookData sourceBookData) {
        Map<String,Object> model=new HashMap<>();
        model.put("Topic", sourceBookData.getTopic());
        model.put("BookDataList",sourceBookData.getBookDataList());
        return model;
    }

    protected Template getTemplate() throws IOException {
        // Load FreeMaker template string
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_29);

        // Create FreeMaker template configuration
        String templateContent= UrlUtil.loadText(FreeMarkerProcessor.class.getResource("/template/md.ftl"));

        // Importer for creating string templates
        StringTemplateLoader stringTemplateLoader=new StringTemplateLoader();

        // Import string template
        stringTemplateLoader.putTemplate("MDTemplate",templateContent);
        configuration.setTemplateLoader(stringTemplateLoader);

        // Get template
        return configuration.getTemplate("MDTemplate");
    }

    // Get the writer and complete the write operation
    protected Writer getWriter(SourceBookData sourceBookData) throws FileNotFoundException, UnsupportedEncodingException {
        String fileName=sourceBookData.getFileName();
        File file=new File(fileName);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
        return bufferedWriter;
    }
}


