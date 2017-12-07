package pl.tomek888.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pl.tomek888.entities.Beer;
import pl.tomek888.entities.User;


public interface BeerRepository extends JpaRepository<Beer, Long> {
	
	
	@Query("select beer from Beer beer where brewery like %:name%")
	List<Beer> findByBreweryName(@Param("name") String name);
	
	@Query("select beer from Beer beer where style like %:name%")
	List<Beer> findByBeerStyle(@Param("name") String name);
	
	@Query("select beer from Beer beer where username like %:name%")
	List<Beer> findByBeerName(@Param("name") String name);
	
	@Query("select beer from Beer beer where alcohol > :value")
	List<Beer> findByAlcoholPercentMore(@Param("value") Long value);
	@Query("select beer from Beer beer where alcohol < :value")
	List<Beer> findByAlcoholPercentLess(@Param("value") Long value);
	
//	@Query("SELECT DISTINCT beer FROM Beer beer LEFT JOIN FETCH beer.user where beer.user=:user")
//	List<Beer> getBeerByUser(@Param("user") String user);
	

}
