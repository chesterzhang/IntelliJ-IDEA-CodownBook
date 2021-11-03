package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class GenSuccessDialog  extends DialogWrapper {
    public GenSuccessDialog() {
        super(true);
        setTitle("Notification");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //窗口布局
        JPanel panel= new JPanel(new BorderLayout());
        JLabel OKLabel =new JLabel("CodownBook is generated successfully!");

        panel.add(OKLabel);

        return panel;
    }

    @NotNull
    @Override
    protected Action[] createActions() {

        Action[] var10000 =  new Action[]{super.getOKAction() };

        return var10000;
    }





}
