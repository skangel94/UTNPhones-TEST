package edu.utn.utnphones.dao;

import edu.utn.utnphones.domain.Call;
import edu.utn.utnphones.projections.CallsByLineCant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallDao extends JpaRepository<Call,Integer> {

    @Query(value = "select u.user_name as name, u.user_lastname as lastname, count(c.call_line_id_from) as cant , pl.line_number as phoneline from users u \n" +
            "inner join phone_lines pl on u.user_id = pl.line_user_id \n" +
            "inner join calls c on c.call_line_id_from = pl.line_id \n" +
            "where u.user_id = ?1\n" +
            "group by pl.line_number \n" +
            "limit 1", nativeQuery = true)
    List<CallsByLineCant> getCallsByLineCants(int userId);
}
