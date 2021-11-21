package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import data.BookData;
import data.DataCenter;
import data.DataConverter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

// Right click and a window pops up in the IDEA. This class is the window class
public class AddCDBookDialog extends DialogWrapper {
    public AddCDBookDialog() {
        super(true);
        setTitle("add CodownBook");
        init();
    }

    private EditorTextField titleField;// Note title text box
    private EditorTextField noteField;// Note content text box

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        // Window layout
        JPanel panel= new JPanel(new BorderLayout());
        titleField=new EditorTextField("enter title here");// Create note title text box
        noteField=new EditorTextField("enter some notes here");// Create note content text box
        noteField.setPreferredSize(new Dimension(400,400));// Set note content text box size
        panel.add(titleField,BorderLayout.NORTH);// Note title text box layout
        panel.add(noteField,BorderLayout.CENTER);// Note content text box layout
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Add code note to List.");// Create a button

        // button listener
        btnAdd.addActionListener(e -> {
            // Get string from text box
            String title=titleField.getText();
            String note=noteField.getText();
            // System.out.println(title+": "+content);

            // Through the selected text, enter the title and content in the text box
            BookData bookData=new BookData(title,note,DataCenter.SELECTED_TEXT,DataCenter.CURRENT_FILE_NAME,DataCenter.CURRENT_FILE_TYPE, DataCenter.FUNC_NAME, DataCenter.FUNC_ACCESS_MODIFIER, DataCenter.FUNC_RETURN_TYPE, DataCenter.FUNC_PARAMETERS);

            // Add the current note to the DataCenter
            DataCenter.BOOK_DATA_LIST.add(bookData);

            // TABLE_ Model is the data structure used to store tables in IDEA, and the addRow method represents adding a row of data
            DataCenter.TABLE_MODEL.addRow(DataConverter.convert(bookData));
        });
        panel.add(btnAdd);

        return panel;
    }
}
