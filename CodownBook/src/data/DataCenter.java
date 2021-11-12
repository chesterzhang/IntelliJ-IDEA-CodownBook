package data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

// 一个 CodownBook 笔记的数据集合
public class DataCenter {

    //选择的文本
    public static String SELECTED_TEXT = null;

    //当前选择的文本的文件名称
    public static String CURRENT_FILE_NAME = null;

    //当前的文件类型, 由文件完整路径截取后面的文件类型而来
    public static String CURRENT_FILE_TYPE = null;

    //一条笔记
//    public static BookData BOOK_DATA = null;
    public static List<BookData> BOOK_DATA_LIST = new LinkedList<>();

    //提取出的函数信息
    public static String FUNC_NAME = null;
    public static String FUNC_ACCESS_MODIFIERS = null;
    public static String FUNC_RETURN_TYPE = null;
    public static String FUNC_PARAMETERS = null;

    //笔记表头, 标题, 评论, 文件名, 选中的文本
    public static String[] BOOK_HEAD={"title","mark","fileName","selectedText"};

    //笔记表格, IDEA 表格的特有数据类型 DefaultTableModel
    public static DefaultTableModel TABLE_MODEL=new DefaultTableModel(null,BOOK_HEAD);



    //当选中代码, 右键 add CodownBook 以后, 将选中的的代码传进来
    public static void setSelectText(String selectText) {
        SELECTED_TEXT  = selectText;
    }

    public  static  void setCurentFileName(String fileName ){
        CURRENT_FILE_NAME=fileName;
    }

    public  static  void setCurentFileType(String fileType ){
        CURRENT_FILE_TYPE=fileType;
    }

    public  static  void setFuncName(String funcName ){
        FUNC_NAME = funcName;
    }

    public  static  void setFuncAccessModifiers(String funcAccModifiers ){
        FUNC_ACCESS_MODIFIERS = funcAccModifiers;
    }

    public  static  void setFuncReturnType(String funcReturnType){
        FUNC_RETURN_TYPE = funcReturnType;
    }

    public  static  void setFuncParameters(String funcParameters ){
        FUNC_PARAMETERS = funcParameters;
    }

    //当按下图形化窗口的 clear button 以后调用这个方法
    public static void clear(){
//        BOOK_DATA=null;
        BOOK_DATA_LIST =null;
        TABLE_MODEL.setDataVector(null, BOOK_HEAD);

    }

    public static void undo(){
        DataCenter.BOOK_DATA_LIST.remove(DataCenter.BOOK_DATA_LIST.size()-1);
        if (TABLE_MODEL.getRowCount()>0){
            TABLE_MODEL.removeRow(TABLE_MODEL.getRowCount()-1);
        }
    }

}
