package pl.tomek888.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tomek888.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
