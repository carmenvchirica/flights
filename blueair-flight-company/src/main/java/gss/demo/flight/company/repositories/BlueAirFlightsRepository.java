package gss.demo.flight.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gss.demo.flight.company.entities.BlueAirFlight;

@Repository
public interface BlueAirFlightsRepository extends JpaRepository<BlueAirFlight, Long> {
	

}
