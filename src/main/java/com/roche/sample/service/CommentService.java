package com.roche.sample.service;

import com.roche.sample.model.Comment;

import java.util.UUID;

public interface CommentService {

  public Comment createComment(Comment comment);
  public Comment getComment(UUID commentId);
  // public Comment patchComment(UUID commentId, Comment comment);
  public void deleteComment(UUID commentId);

}