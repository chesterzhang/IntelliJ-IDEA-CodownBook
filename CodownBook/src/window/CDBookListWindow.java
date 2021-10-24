package window;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import data.DataCenter;
import org.jetbrains.annotations.NotNull;
import processor.FreeMarkerProcessor;
import processor.SourceBookData;

import processor.Processor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CDBookListWindow {
    private JTextField CDBookTopicTextField;
    private JTable BookDataTable;
    private JButton generateButton;
    private JButton clearButton;
    private JButton closeButton;
    private JPanel contentPanel;

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void init(){
        BookDataTable.setModel(DataCenter.TABLE_MODEL);
        BookDataTable.setEnabled(true);
    }

    public CDBookListWindow(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        init();

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //选择路径,生成文档
                String bookTopic= CDBookTopicTextField.getText();
                //获取文件名
                String fileName = bookTopic + ".md";
                if (fileName == null || fileName.equals("")) {
                    MessageDialogBuilder.yesNo("Warming", "Please enter CodownBook fileName");
                    return;
                }

                //获取文件路径
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String savePath = virtualFile.getPath();
                    String fileFullPath = savePath + "/" + fileName;

                    Processor processor=new FreeMarkerProcessor();
                    try {
                        processor.process(new SourceBookData(fileFullPath,bookTopic,DataCenter.BOOK_DATA));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.clear();//清空笔记
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);//关闭窗口
            }
        });
    }
}
