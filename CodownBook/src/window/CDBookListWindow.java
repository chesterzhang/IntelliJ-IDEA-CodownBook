package window;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import data.DataCenter;
import dialog.GenSuccessDialog;
import org.jetbrains.annotations.NotNull;
import processor.FreeMarkerProcessor;
import processor.SourceBookData;

import processor.Processor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CDBookListWindow {
    private JTextField CDBookTopicTextField;
    private JTable BookDataTable;
    private JButton generateButton;
    private JButton clearButton;
    private JButton closeButton;
    private JPanel contentPanel;
    private JButton undoButton;


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
                // Select a path to generate a document
                String bookTopic= CDBookTopicTextField.getText();
                // Get the file name, which is topic plus .md
                String fileName = bookTopic + ".md";
                if (bookTopic == null || bookTopic.equals("")) {
                    MessageDialogBuilder.yesNo("Warming", "Please enter CodownBook topic !");
                    return;
                }

                // Get the file path
                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String savePath = virtualFile.getPath();
                    String fileFullPath = savePath + "/" + fileName;

                    Processor processor=new FreeMarkerProcessor();
                    try {
                        processor.process(new SourceBookData(fileFullPath,bookTopic,DataCenter.BOOK_DATA_LIST));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }

                GenSuccessDialog genSuccessDialog = new GenSuccessDialog();
                genSuccessDialog.show();

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.clear();// Empty notes
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);// Remove the last line
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                DataCenter.undo();// Undo
            }
        });
    }
}
