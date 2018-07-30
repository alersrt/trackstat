package org.student.trackstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student.trackstat.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
