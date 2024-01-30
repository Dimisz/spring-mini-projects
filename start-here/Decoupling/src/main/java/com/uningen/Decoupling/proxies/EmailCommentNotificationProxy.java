package com.uningen.Decoupling.proxies;

import com.uningen.Decoupling.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("Email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " +
                comment.getText());
    }
}
