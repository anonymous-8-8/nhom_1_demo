package edu.poly.test_qlda.service.IMP;

import edu.poly.test_qlda.entity.*;
import edu.poly.test_qlda.infrastructure.converter.ProductConver;
import edu.poly.test_qlda.infrastructure.converter.SubCategoryConver;
import edu.poly.test_qlda.infrastructure.request.ProductRequest;
import edu.poly.test_qlda.infrastructure.request.SubCategoryRequest;
import edu.poly.test_qlda.repository.*;
import edu.poly.test_qlda.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.poly.test_qlda.infrastructure.response.ProductResponse;
import edu.poly.test_qlda.service.IProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductConver productConver;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ISubCategoryRepository subCategoryRepository;
    @Autowired
    private IBrandRepository brandRepository;
    @Autowired
    private IStatusRepository statusRepository;


    @Override
    public String createProduct(ProductRequest request, Long id) {
        String erro = "";
        boolean check = true;
        if (Objects.isNull(request)) {
            erro += "không được để trống thông tin";
        } else {
            if (request.getProduceName().isEmpty()) {
                erro += "không để trông Name\n";
                check = false;
            }
            if (request.getColer().isEmpty()) {
                erro += "không để trông Color\n";
                check = false;
            }
            if (request.getDescription().isEmpty()) {
                erro += "không để trông Description\n";
                check = false;
            }
            if ((Math.ceil(request.getQuantity()) != Math.floor(request.getQuantity())) || request.getQuantity() < 0) {
                erro += "Quantity phải là số nguyên dương\n";
                check = false;
            }
            if (request.getSellPDrice() < request.getOriginPrice()) {
                erro += "SellPDrice phải lớn hơn OriginPrice\n";
                check = false;
            }
            Optional<SubCategoryEntity> subCategoryEntity = subCategoryRepository.findById(request.getSubcateId());
            if (!subCategoryEntity.isPresent()) {
                erro += "subcate_id không tồn tại trong list sub_category\n";
                check = false;
            }
            Optional<StatusEntity> statusEntity = statusRepository.findById(request.getStatusId());
            if (!statusEntity.isPresent()) {
                erro += "status_id không tồn tại trong list status\n";
                check = false;
            }
            if (check == true) {
                ProductEntity entity = new ProductEntity();
                if (id == null) {
                    entity = productConver.ConverProductDTOToEntity(request);
                    erro = "lưu thành công product";
                } else {
                    Optional<ProductEntity> productEntity = productRepository.findById(id);
                    entity = productConver.ConverProductDTOToEntity(productEntity.get(), request);
                    erro = "Update thành công product";
                }
                List<BrandEntity> brandEntityList1 = brandRepository.findAllById(request.getBrandId());
                entity.setBrands(brandEntityList1);
                entity.setSubCateId(subCategoryEntity.get());
                entity.setStatusId(statusEntity.get());
                productRepository.save(entity);
            }
        }
        return erro;
    }


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
