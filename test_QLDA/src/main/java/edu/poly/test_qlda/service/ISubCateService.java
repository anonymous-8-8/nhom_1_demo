package edu.poly.test_qlda.service;
import edu.poly.test_qlda.infrastructure.response.SubCategoryResponse;
import edu.poly.test_qlda.infrastructure.request.SubCategoryRequest;

import java.util.List;
public interface ISubCateService {
    String saveSubCategory(SubCategoryRequest dto, Long id);
    List<SubCategoryResponse> findAllSubCate(int page);
}
