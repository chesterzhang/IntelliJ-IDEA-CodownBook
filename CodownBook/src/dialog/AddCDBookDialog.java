package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import data.BookData;
import data.DataCenter;
import data.DataConverter;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

// 鼠标右键,IDEA 中弹出来一个窗口, 这个类就是窗口类
public class AddCDBookDialog extends DialogWrapper {
    public AddCDBookDialog() {
        super(true);
        setTitle("add CodownBook");
        init();
    }

    private EditorTextField titleField;//笔记标题文本框
    private EditorTextField markField;//笔记内容文本框

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //窗口布局
        JPanel panel= new JPanel(new BorderLayout());
        titleField=new EditorTextField("enter title here");//创建笔记标题文本框
        markField=new EditorTextField("enter mark here");//创建笔记内容文本框
        markField.setPreferredSize(new Dimension(200,200));//设置笔记内容文本框大小
        panel.add(titleField,BorderLayout.NORTH);//笔记标题文本框布局
        panel.add(markField,BorderLayout.CENTER);//笔记内容文本框布局
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Add code note to List.");//创建一个button

        //button监听器
        btnAdd.addActionListener(e -> {
            //从文本框获取字符串
            String title=titleField.getText();
            String mark=markField.getText();
//            System.out.println(title+": "+content);


            //通过选择的文本, 在文本框内输入的标题, 内容
            BookData bookData=new BookData(title,mark,DataCenter.SELECTED_TEXT,DataCenter.CURRENT_FILE_NAME,DataCenter.CURRENT_FILE_TYPE);



            //将当前这一条笔记加入到 DataCenter中
            DataCenter.BOOK_DATA_LIST.add(bookData);

            //TABLE_MODEL 是 IDEA 中用来存储表格的数据结构, addRow 方法表示 加一行数据
            DataCenter.TABLE_MODEL.addRow(DataConverter.convert(bookData));
        });
        panel.add(btnAdd);


        return panel;

    }



}
