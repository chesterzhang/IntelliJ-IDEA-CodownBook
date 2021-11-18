package processor;

import data.BookData;

import java.util.List;

// Final data type to FreeMarker for processing
public class SourceBookData {
    private String fileName;// The file name is the topic of codownbook plus .md
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
