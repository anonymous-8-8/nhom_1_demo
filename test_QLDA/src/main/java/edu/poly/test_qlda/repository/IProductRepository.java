package edu.poly.test_qlda.repository;

import edu.poly.test_qlda.infrastructure.response.ProductResponse;
import edu.poly.test_qlda.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<ProductEntity , Long> {
    @Query("select new edu.poly.test_qlda.infrastructure.response.ProductResponse(p.id , p.subCateId.subCateName ,p.productName,p.color,p.quantity," +
            "p.sellPrice,p.originPrice,p.statusId.statusName, b.brandName)" +
            " from ProductEntity p inner join p.brands b")
    List<ProductResponse> findAllProduct(Pageable pageable);
}
