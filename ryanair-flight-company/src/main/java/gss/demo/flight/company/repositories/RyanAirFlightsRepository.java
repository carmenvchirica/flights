package gss.demo.flight.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gss.demo.flight.company.entities.RyanAirFlight;

@Repository
public interface RyanAirFlightsRepository extends JpaRepository<RyanAirFlight, Long> {
	

}
