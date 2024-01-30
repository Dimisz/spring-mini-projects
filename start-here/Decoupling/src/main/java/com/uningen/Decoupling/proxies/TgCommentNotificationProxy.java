package com.uningen.Decoupling.proxies;

import com.uningen.Decoupling.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Telegram")
public class TgCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sent a message by Telegram that the comment: '" +
                comment.getText() + "' was posted by " + comment.getAuthor());
    }
}
