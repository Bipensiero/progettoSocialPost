package it.jaita88.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.model.SocialPost;
import it.jaita88.repository.SocialPostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private final SocialPostRepository socialPostRepository;
	

    public PostController(SocialPostRepository socialPostRepository) {
        this.socialPostRepository = socialPostRepository;
    }
	
    @GetMapping
    public List<SocialPost> getAllPosts(){
    	return socialPostRepository.findAll();
    }
    
    @PostMapping
    public SocialPost createPost(@RequestBody SocialPost post) {
    	return socialPostRepository.save(post);
    }
}
