package edu.poly.test_qlda.service.IMP;


import edu.poly.test_qlda.entity.ProductEntity;
import edu.poly.test_qlda.infrastructure.response.ProductResponse;
import edu.poly.test_qlda.repository.IProductRepository;
import edu.poly.test_qlda.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public String deleteProduct(Long id) {
        Optional<ProductEntity> entity = productRepository.findById(id);
        if (!entity.isPresent()) {
            return "id không tồn tại trong product";
        } else {
            productRepository.delete(entity.get());
            return "xóa thành công";
        }
    }

    @Override
    public List<ProductResponse> findAllProduct(Pageable pageable) {
        List<ProductResponse> list = productRepository.findAllProduct(pageable);
        return list;
    }
}
