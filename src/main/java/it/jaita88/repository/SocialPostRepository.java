package it.jaita88.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import it.jaita88.model.SocialPost;

public interface SocialPostRepository extends JpaRepository<SocialPost, Long>{

//	@Query(value ="SELECT post_id FROM post_likes GROUP BY post_id ORDER BY COUNT(*) DESC LIMIT 1;", nativeQuery = true)
//	SocialPost mostLikedPost();
}
