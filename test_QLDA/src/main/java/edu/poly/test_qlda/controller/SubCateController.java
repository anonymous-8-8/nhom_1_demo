package edu.poly.test_qlda.controller;

import edu.poly.test_qlda.infrastructure.response.SubCategoryResponse;
import edu.poly.test_qlda.infrastructure.request.SubCategoryRequest;
import edu.poly.test_qlda.service.ISubCateService;
import edu.poly.test_qlda.service.ISubCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subcate")
public class SubCateController {
    @Autowired
    private ISubCateService iSubCategoryService;

    @GetMapping
    public List<SubCategoryResponse> findAllSubCate(@RequestParam("page") int page){
        return iSubCategoryService.findAllSubCate(page);
    }

    @PostMapping
    public ResponseEntity<String> creatSubCate(@RequestParam SubCategoryRequest dto){
        String error = iSubCategoryService.saveSubCategory(dto , null);
        return  new ResponseEntity<>(error, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateSubCate(@RequestBody SubCategoryRequest dto ,
                                                @PathVariable("id") Long id){
        String error = iSubCategoryService.saveSubCategory(dto , id);
        return  new ResponseEntity<>(error, HttpStatus.CREATED);
    }
}
