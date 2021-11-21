package data;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

// A data collection of CodownBook notes
public class DataCenter {

    // Selected text
    public static String SELECTED_TEXT = null;

    // The file name of the currently selected text
    public static String CURRENT_FILE_NAME = null;

    //The current file type is obtained by intercepting the following file type from the full file path
    public static String CURRENT_FILE_TYPE = null;

    // One note
    // public static BookData BOOK_DATA = null;
    public static List<BookData> BOOK_DATA_LIST = new LinkedList<>();

    // Extracted function information
    public static String FUNC_NAME = null;
    public static String FUNC_ACCESS_MODIFIER = null;
    public static String FUNC_RETURN_TYPE = null;
    public static String FUNC_PARAMETERS = null;

    // Note header, title, comment, file name, selected text
    public static String[] BOOK_HEAD={"title","notes","fileName","selectedText"};

    // Note table, unique data type of IDEA table DefaultTableModel
    public static DefaultTableModel TABLE_MODEL=new DefaultTableModel(null,BOOK_HEAD);



    // When the code is selected, right-click add CodewnBook to transfer the selected code
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

    public  static  void setFuncAccessModifier(String funcAccModifier ){
        FUNC_ACCESS_MODIFIER = funcAccModifier;
    }

    public  static  void setFuncReturnType(String funcReturnType){
        FUNC_RETURN_TYPE = funcReturnType;
    }

    public  static  void setFuncParameters(String funcParameters ){
        FUNC_PARAMETERS = funcParameters;
    }

    // This method is called after pressing the clear button of the graphical window.
    public static void clear(){
        BOOK_DATA_LIST.clear();
        TABLE_MODEL.setDataVector(null, BOOK_HEAD);

    }

    public static void undo(){
        DataCenter.BOOK_DATA_LIST.remove(DataCenter.BOOK_DATA_LIST.size()-1);
        if (TABLE_MODEL.getRowCount()>0){
            TABLE_MODEL.removeRow(TABLE_MODEL.getRowCount()-1);
        }
    }

}
