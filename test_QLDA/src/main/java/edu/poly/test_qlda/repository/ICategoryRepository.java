package edu.poly.test_qlda.repository;

import edu.poly.test_qlda.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity , Long>{
}
