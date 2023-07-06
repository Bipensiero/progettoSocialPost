package it.jaita88.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SocialPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	@ManyToOne
	private UserT author;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CommentT> comments;
	
	@ManyToMany
	@JoinTable(name = "post_likes", 
	joinColumns = @JoinColumn(name = "post_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<UserT> likes;
	
	

	public SocialPost() {
	}

	public SocialPost(Long id, String content, UserT author, List<CommentT> comments, List<UserT> likes) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.comments = comments;
		this.likes = likes;
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

	public UserT getAuthor() {
		return author;
	}

	public void setAuthor(UserT author) {
		this.author = author;
	}

	public List<CommentT> getComments() {
		return comments;
	}

	public void setComments(List<CommentT> comments) {
		this.comments = comments;
	}

	public List<UserT> getLikes() {
		return likes;
	}

	public void setLikes(List<UserT> likes) {
		this.likes = likes;
	}
	
	
	
}
