package gss.demo.flight.company.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gss.demo.flight.company.entities.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

	List<Airport> findByCode(String code);
	
}
