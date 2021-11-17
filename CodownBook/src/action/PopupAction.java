package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import data.DataCenter;
import data.ExtractFunction;
import dialog.AddCDBookDialog;

// Create an action in IDEA. That is, right-click to generate a window
public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        // Test whether the add codownbook menu option pops up by right clicking
        // System.out.println("add CodownBook memu test");

        // Gets the current editor object
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);

        // Get selected data model
        SelectionModel selectionModel = editor.getSelectionModel();

        // Gets the currently selected text
        String selectedText = selectionModel.getSelectedText();
        // System.out.println(selectedText);//test OK

        // Send the selected text into the DataCenter class for processing
        DataCenter.setSelectText(selectedText);

        // Pass the selected text into ExtractFunction for processing
        String jsonFunctionInfo = ExtractFunction.Extract(selectedText);

        // Get the returned JSON data
        JSONArray jsonArray = JSON.parseArray(jsonFunctionInfo);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String funcName = jsonObject.getString("FunctionName");
        String funcAccModifiers = jsonObject.getString("FunctionAccMod");
        String funcReturnType = jsonObject.getString("FunctionRetType");
        String funcParameters = jsonObject.getString("FunctionPara");

        DataCenter.setFuncName(funcName);
        DataCenter.setFuncAccessModifiers(funcAccModifiers);
        DataCenter.setFuncReturnType(funcReturnType);
        DataCenter.setFuncParameters(funcParameters);

        // Pass the file name of the selected text into the DataCenter class for processing
        String name=e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.setCurentFileName(name);

        // Extract the file type from the file name and pass it into the DataCenter
        String fileType= DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".")+1);
        DataCenter.setCurentFileType(fileType);

        // Pop up AddCDbookDialog, that's a window
        AddCDBookDialog addCDBookDialog=new AddCDBookDialog();
        addCDBookDialog.show();






    }
}
