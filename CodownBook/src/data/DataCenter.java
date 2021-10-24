package data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

public class DataCenter {

    //选择的文本
    public static String SELECTED_TEXT = null;

    //当前选择的文本的文件名称
    public static String CURRENT_FILE_NAME = null;

    //当前的文件类型
    public static String CURRENT_FILE_TYPE = null;

    //一条笔记
    public static BookData BOOK_DATA = null;

    //笔记表头
    public static String[] BOOK_HEAD={"title","mark","fileName","selectedText"};

    //笔记表格, IDEA 表格的特有数据类型 DefaultTableModel
    public static DefaultTableModel TABLE_MODEL=new DefaultTableModel(null,BOOK_HEAD);



    //当选中代码, 右键 add CodownBook 以后, 讲选中的的代码传进来
    public static void setSelectText(String selectText) {
        SELECTED_TEXT  = selectText;
    }

    public  static  void setCurentFileName(String fileName ){
        CURRENT_FILE_NAME=fileName;
    }

    public  static  void setCurentFileType(String fileType ){
        CURRENT_FILE_TYPE=fileType;
    }

    public static void clear(){
        BOOK_DATA=null;
        TABLE_MODEL.setDataVector(null, BOOK_HEAD);
    }

}
