package processor;

import data.BookData;

import java.util.List;

//交给 FreeMarker 处理的最终数据类型
public class SourceBookData {
    private String fileName;
    private String topic;
    private BookData bookData;

    public SourceBookData(String fileName, String topic, BookData bookData) {
        this.fileName = fileName;
        this.topic = topic;
        this.bookData = bookData;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTopic() {
        return topic;
    }

    public BookData getBookData() {
        return bookData;
    }
}
