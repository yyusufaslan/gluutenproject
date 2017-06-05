package com.gluuten.service;

import com.gluuten.domain.Comment;
import com.gluuten.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yusufaslan on 31.05.2017.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getCommentById(Long id)
    {
        return commentRepository.findOne(id);
    }

    public List<Comment> getCommentsByCommentSender(Long senderId)
    {
        return commentRepository.findByCommentSenderOrderByPostDate(senderId);
    }

    public List<Comment> findByCommentOfPostOrderByCommentDate(Long senderId)
    {
       return commentRepository.findByCommentOfPostOrderByCommentDate(senderId);
    }

    public void updateComment(Comment comment)
    {
        commentRepository.updateComment(comment.getId(),comment.getCommentBody());
    }

    public void saveComment(Comment comment)
    {
        commentRepository.save(comment);
    }

    public void deleteComment(Long id)
    {
        commentRepository.delete(id);
    }






}
