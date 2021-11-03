package data;

//每一行 CodownBook 的内容, 有笔记标题,  评论, 被选中的文本,  文件名, 文件类型
public class BookData {

    private String title;//笔记标题
    private String mark;//评论
    private String selectedText;//代码内被选中的内容
    private String fileName;//文件名
    private String fileType;//文件类型


    public BookData(String title, String mark, String selectedText, String fileName, String fileType) {
        this.title = title;
        this.mark = mark;
        this.selectedText = selectedText;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }



    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", selectedText='" + selectedText + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }

}
