package it.jaita88.model;

public class CommentRequest {
	
	private String content;
	private Long postId;
	private Long userId;
	
	
	public CommentRequest() {
	}
	public CommentRequest(String content, Long postId, Long userId) {
		this.content = content;
		this.postId = postId;
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
