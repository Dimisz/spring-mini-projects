package com.uningen.Decoupling.repositories;

import com.uningen.Decoupling.models.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
