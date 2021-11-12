package processor;

import data.BookData;

import java.util.List;

//交给 FreeMarker 处理的最终数据类型
public class SourceBookData {
    private String fileName;// 文件名, 就是 CodownBook 的topic 加上 .md 后缀
    private String topic;
    private List<BookData> bookDataList;

    public SourceBookData(String fileName, String topic, List<BookData> bookDataList) {
        this.fileName = fileName;
        this.topic = topic;
        this.bookDataList= bookDataList;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTopic() {
        return topic;
    }

    public List<BookData>getBookDataList() {
        return bookDataList;
    }
}
