package edu.utn.utnphones.dao;

import edu.utn.utnphones.domain.Rate;
import edu.utn.utnphones.domain.RateCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateDao extends JpaRepository<Rate, RateCompositeKey> {

    @Query(value = "SELECT * FROM rates r WHERE r.city_from_id = ?1", nativeQuery = true)
    List<Rate> getByIdFrom(int idFrom);

    @Query(value = "SELECT * FROM rates r WHERE r.city_to_id = ?1",nativeQuery = true)
    List<Rate> getByIdTo(int idTo);
}
