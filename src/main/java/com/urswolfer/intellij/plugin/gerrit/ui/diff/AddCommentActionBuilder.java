package com.urswolfer.intellij.plugin.gerrit.ui.diff;

import com.google.inject.Inject;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.vcs.FilePath;
import com.urswolfer.intellij.plugin.gerrit.ReviewCommentSink;
import com.urswolfer.intellij.plugin.gerrit.git.GerritGitUtil;
import com.urswolfer.intellij.plugin.gerrit.rest.bean.ChangeInfo;
import com.urswolfer.intellij.plugin.gerrit.rest.bean.CommentBase;
import org.jetbrains.annotations.Nullable;

/**
 * @author Thomas Forrer
 */
public class AddCommentActionBuilder {
    @Inject
    private GerritGitUtil gerritGitUtil;
    @Inject
    private CommentBalloonBuilder commentBalloonBuilder;

    public AddCommentAction build(
            ReviewCommentSink reviewCommentSink,
            ChangeInfo changeInfo,
            @Nullable Editor editor,
            @Nullable FilePath filePath,
            CommentBase.CommentSide commentSide) {
        return new AddCommentAction(reviewCommentSink, changeInfo, editor, filePath,
                gerritGitUtil, commentBalloonBuilder, commentSide);
    }
}
