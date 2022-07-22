package edu.poly.test_qlda.repository;

import edu.poly.test_qlda.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
}
