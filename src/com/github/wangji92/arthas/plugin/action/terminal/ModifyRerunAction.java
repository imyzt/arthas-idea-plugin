package com.github.wangji92.arthas.plugin.action.terminal;

import com.github.wangji92.arthas.plugin.ui.ArthasTerminalOptionsDialog;
import com.github.wangji92.arthas.plugin.utils.ArthasTerminalManager;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * ModifyRerunAction
 * @author https://github.com/imyzt
 */
public class ModifyRerunAction extends AnAction {

    private final Project project;
    private final Editor editor;
    private final ArthasTerminalManager manager;
    private final String cmd;

    public ModifyRerunAction(Project project, Editor editor, ArthasTerminalManager manager, String cmd) {
        super("Modify", "ModifyCmd", AllIcons.Actions.Edit);
        this.project = project;
        this.editor = editor;
        this.manager = manager;
        this.cmd = cmd;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        this.manager.stop();
        new ArthasTerminalOptionsDialog(project, this.cmd, this.editor).open();
    }

}
