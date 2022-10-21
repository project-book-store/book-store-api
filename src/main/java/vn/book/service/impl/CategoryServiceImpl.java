package vn.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.book.model.Category;
import vn.book.repository.ICategoryRepository;
import vn.book.service.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findByAll() {
        return categoryRepository.findAll();
    }
}
