package it.jaita88.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CommentT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	@ManyToOne
	private SocialPost post;
	
	@ManyToOne
	private UserT author;
	
	public CommentT() {
	}

	public CommentT(Long id, String content, SocialPost post, UserT author) {
		this.id = id;
		this.content = content;
		this.post = post;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public SocialPost getPost() {
		return post;
	}

	public void setPost(SocialPost post) {
		this.post = post;
	}

	public UserT getAuthor() {
		return author;
	}

	public void setAuthor(UserT author) {
		this.author = author;
	}
	
	
}
