package edu.poly.test_qlda.repository;

import edu.poly.test_qlda.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<StatusEntity , Long> {
}
