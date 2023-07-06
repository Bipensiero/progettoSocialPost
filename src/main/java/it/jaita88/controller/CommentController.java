package it.jaita88.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.model.CommentT;
import it.jaita88.repository.CommentRepository;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	private final CommentRepository commentRepository;
	
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @PostMapping
    public CommentT createComment(@RequestBody CommentT comment) {
        return commentRepository.save(comment);
    }
    
    @GetMapping
    public List<CommentT> getAllComments() {
        return commentRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public CommentT getUserById(@PathVariable Long id) {
        return commentRepository.findById(id).get();
    }
}
