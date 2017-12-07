package pl.tomek888.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.tomek888.entities.Beer;
import pl.tomek888.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	


}
