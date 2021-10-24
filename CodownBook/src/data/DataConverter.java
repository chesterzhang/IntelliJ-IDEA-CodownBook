package data;

//将 bookData 的 title, mark, fileName, selectedText提取出来, 放到一个String数组
public class DataConverter {
    public static  String[] convert(BookData bookData){
        String[] row =new String[4];
        row[0]=bookData.getTitle();
        row[1]=bookData.getMark();
        row[2]=bookData.getFileName();
        row[3]=bookData.getSelectedText();
        return  row;
    }
}
