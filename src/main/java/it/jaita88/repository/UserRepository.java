package it.jaita88.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.jaita88.model.UserT;

public interface UserRepository extends JpaRepository<UserT, Long>{

}
