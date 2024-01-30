package com.uningen.Decoupling.services;

import com.uningen.Decoupling.models.Comment;
import com.uningen.Decoupling.proxies.CommentNotificationProxy;
import com.uningen.Decoupling.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    @Qualifier("Telegram")
    private CommentNotificationProxy commentNotificationProxy;

//    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//        this.commentRepository = commentRepository;
//        this.commentNotificationProxy = commentNotificationProxy;
//    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
