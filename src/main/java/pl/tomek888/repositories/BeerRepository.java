package pl.tomek888.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tomek888.entities.Beer;


public interface BeerRepository extends JpaRepository<Beer, Long> {

}
