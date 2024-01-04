package com.roche.sample.controller;

import com.roche.sample.model.Comment;
import com.roche.sample.service.CommentService;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public String index() {
        return "Greetings from Spring Boot index for comment!";
    }

    @GetMapping("/comment/{id}")
    public String get(@PathVariable UUID id) {
        this.commentService.getComment(id);
        return "You got comment" + id + "!";
    }

    @PostMapping("/comment")
    public String post(@ModelAttribute Comment comment) {
        this.commentService.createComment(comment);
        return "You got comment!";
    }

    // @PatchMapping("/comment/{id}")
    // public String update(@PathVariable UUID id) {
    //     return "You got comment" + id + "!";
    // }

    @DeleteMapping("/comment/{id}")
    public String delete(@PathVariable UUID id) {
        this.commentService.getComment(id);
        return "You deleted comment" + id + "!";
    }
}