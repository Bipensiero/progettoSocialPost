package it.jaita88.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.model.CommentRequest;
import it.jaita88.model.CommentT;
import it.jaita88.model.SocialPost;
import it.jaita88.model.UserT;
import it.jaita88.repository.SocialPostRepository;
import it.jaita88.repository.UserRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private final SocialPostRepository socialPostRepository;
	
	@Autowired
	private final UserRepository userRepository;
	

    public PostController(SocialPostRepository socialPostRepository, UserRepository userRepository) {
        this.socialPostRepository = socialPostRepository;
        this.userRepository = userRepository;
    }
    
    
	
    @GetMapping
    public List<SocialPost> getAllPosts(){
    	return socialPostRepository.findAll();
    }
    
    @GetMapping("/{postId}")
	public SocialPost getPostById(@PathVariable Long postId) {
		return socialPostRepository.findById(postId).get();
	}
    
    @PostMapping
    public SocialPost createPost(@RequestBody SocialPost post) {
    	return socialPostRepository.save(post);
    }
    //UPDATE
    @PutMapping("/updatePost/{postId}")
    public SocialPost updatePost(@PathVariable Long postId, @RequestBody SocialPost socialPost) {
    	SocialPost post = socialPostRepository.findById(postId).get();
    	
    	//post.setContent(socialPost.getContent());
    	
    	return socialPostRepository.save(post);
    }
    
    @PutMapping("/updatePostString/{postId}")
    public SocialPost updatePost(@PathVariable Long postId, @RequestBody String content) {
    	
    	SocialPost post = socialPostRepository.findById(postId).get();
    	post.setContent(content);
    	
    	return socialPostRepository.save(post);
    }
    
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId){
    	
    	SocialPost post = socialPostRepository.findById(postId).get();
    	socialPostRepository.delete(post);
    	
    	return ResponseEntity.ok("Post deleted successfully");
    }
    
    
    @PutMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest) {
    	//recupero il socialpost dal DB
    	SocialPost post = socialPostRepository.findById(commentRequest.getPostId()).get();
    	
    	//creo un ogg comment con i dati della richiesta
    	CommentT comment = new CommentT();
    	comment.setContent(commentRequest.getContent());
    	
    	//recupero utente che mette il commento da DB
    	UserT user = userRepository.findById(commentRequest.getUserId()).get();
    	
    	comment.setAuthor(user);
    	comment.setPost(post);
    	
    	post.getComments().add(comment);
    	
    	socialPostRepository.save(post);
    	
    	return ResponseEntity.ok("Comment added successfully");
    }
    
    @PutMapping("/addLike/{postId}/like/{userId}")
    public ResponseEntity<String> addLike(@PathVariable Long postId, @PathVariable Long userId){
    	SocialPost post = socialPostRepository.findById(postId).get();
    	UserT user = userRepository.findById(userId).get();
    	
    	if(post.getLikes().contains(user)) {
    		post.getLikes().remove(user);
    		socialPostRepository.save(post);
    		return ResponseEntity.ok("Like removed successfully");
    	}
    	post.getLikes().add(user);

    	socialPostRepository.save(post);
    	
    	return ResponseEntity.ok("Like added successfully");
    }
    
//    @GetMapping("/bestPost")
//    public SocialPost bestPost() {
//    	return socialPostRepository.mostLikedPost();
//    }
}
