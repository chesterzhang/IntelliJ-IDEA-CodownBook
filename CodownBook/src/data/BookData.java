package data;

// Each line of CodownBook content, including note title, comment, selected text, file name and file type
public class BookData {

    private String title;// Title
    private String mark;// Commit
    private String selectedText;// Selected content in code
    private String fileName;// File name
    private String fileType;// File type
    private String funcName;// Extracted function name
    private String funcAccModifier;// Extracted function access modifier
    private String funcReturnType;// Extracted function return value type
    private String funcParameters;// Extracted function parameters

    public BookData(String title, String mark, String selectedText, String fileName, String fileType, String funcName, String funcAccModifier, String funcReturnType, String funcParameters) {
        this.title = title;
        this.mark = mark;
        this.selectedText = selectedText;
        this.fileName = fileName;
        this.fileType = fileType;
        this.funcName = funcName;
        this.funcAccModifier = funcAccModifier;
        this.funcReturnType = funcReturnType;
        this.funcParameters = funcParameters;
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

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncAccModifier() {
        return funcAccModifier;
    }

    public void setFuncAccModifier(String funcAccModifier) {
        this.funcAccModifier = funcAccModifier;
    }

    public String getFuncReturnType() {
        return funcReturnType;
    }

    public void setFuncReturnType(String funcReturnType) {
        this.funcReturnType = funcReturnType;
    }

    public String getFuncParameters() {
        return funcParameters;
    }

    public void setFuncParameters(String funcParameters) {
        this.funcParameters = funcParameters;
    }



    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", selectedText='" + selectedText + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", funcName='" + funcName + '\'' +
                ", funcAccModifier='" + funcAccModifier + '\'' +
                ", funcReturnType='" + funcReturnType + '\'' +
                ", funcParameters='" + funcParameters + '\'' +
                '}';
    }

}
