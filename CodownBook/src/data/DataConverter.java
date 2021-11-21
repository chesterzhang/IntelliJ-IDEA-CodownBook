package data;

// Extract the title, mark, fileName, selectedText of bookData, put them into a String array
public class DataConverter {
    public static  String[] convert(BookData bookData){
        String[] row =new String[4];
        row[0]=bookData.getTitle();
        row[1]=bookData.getNote();
        row[2]=bookData.getFileName();
        row[3]=bookData.getSelectedText();
        return  row;
    }
}
