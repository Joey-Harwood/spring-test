package com.roche.sample.service;

import com.roche.sample.model.Comment;
import com.roche.sample.repository.CommentRepository;
import com.roche.sample.service.CommentService;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired private CommentRepository commentRepository;

  @Override
  public Comment createComment(Comment comment) {
    return this.commentRepository.save(comment);
  }

  @Override
  public Comment getComment(UUID commentId) {
    Optional<Comment> optionalComment= commentRepository.findById(commentId);
    if (optionalComment.isPresent()) {
      return optionalComment.get();
    } else {
        throw new RuntimeException("comment not found with id: " + commentId);
    }
  }

  // @Override
  // public Comment patchComment(UUID commentId, Comment comment) {
  //   Optional<Comment> optionalComment= commentRepository.findById(commentId);
  //   if (optionalComment.isPresent()) {
  //     comment = optionalComment.get();
  //   } else {
  //       throw new RuntimeException("comment not found with id: " + commentId);
  //   }
  //   return comment;
  // }

  @Override
  public void deleteComment(UUID commentId) {
    this.commentRepository.deleteById(commentId);
  }

}