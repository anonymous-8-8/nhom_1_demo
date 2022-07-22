package edu.poly.test_qlda.service;

import edu.poly.test_qlda.infrastructure.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    String deleteProduct(Long id);
    List<ProductResponse> findAllProduct(Pageable pageable);

}
