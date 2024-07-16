package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.entity1;

public interface repository extends JpaRepository<entity1,Long>{

	String getEmail();

}
