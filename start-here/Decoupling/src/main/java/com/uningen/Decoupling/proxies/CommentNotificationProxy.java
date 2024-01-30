package com.uningen.Decoupling.proxies;

import com.uningen.Decoupling.models.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
