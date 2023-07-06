package it.jaita88.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.jaita88.model.CommentT;

public interface CommentRepository extends JpaRepository<CommentT, Long> {

}
