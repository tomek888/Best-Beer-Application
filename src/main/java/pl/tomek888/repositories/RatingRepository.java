package pl.tomek888.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tomek888.entities.Rating;



public interface RatingRepository  extends JpaRepository<Rating, Long>  {

}
