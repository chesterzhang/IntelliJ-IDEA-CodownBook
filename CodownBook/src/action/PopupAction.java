package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import data.DataCenter;
import dialog.AddCDBookDialog;

public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        //测试右键是否弹出 addd CodownBook 菜单选项
        //System.out.println("add CodownBook memu test"); //测试OK

        //获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();
        //System.out.println(selectedText);//测试OK

        //将选择的文本传入到 DataCenter 类中处理
        DataCenter.setSelectText(selectedText);

        //将选择的文本的文件名称传入到 DataCenter 类中处理
        String name=e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.setCurentFileName(name);

        //从文件名截取出文件类型, 传入 DataCenter
        String fileType= DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".")+1);
        DataCenter.setCurentFileType(fileType);

        //弹出 AddCDbookDialog, 也就是一个窗口
        AddCDBookDialog addCDBookDialog=new AddCDBookDialog();
        addCDBookDialog.show();

    }
}
