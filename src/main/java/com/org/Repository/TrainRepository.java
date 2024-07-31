package com.org.Repository;

import com.org.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train,Integer> {
    @Query(value = "SELECT t.name FROM task.train t JOIN task.train_stations ts ON ts.train_number = t.number WHERE ts.stations IN (?1, ?2) GROUP BY t.name HAVING COUNT(DISTINCT ts.stations) = 2;",nativeQuery = true)
    List<String> findByStation(String source,String Destination);

}
