package window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

//Let IDEA know our CDBookListWindow
public class BookWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        CDBookListWindow noteListWindows=new CDBookListWindow(project,toolWindow);
        ContentFactory contentFactory=ContentFactory.SERVICE.getInstance();
        Content content =contentFactory.createContent(noteListWindows.getContentPanel(),"",false);
        toolWindow.getContentManager().addContent(content);
    }
}
