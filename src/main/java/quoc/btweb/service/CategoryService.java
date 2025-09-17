package quoc.btweb.service;

import quoc.btweb.entity.Category;
import quoc.btweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> listAll(String keyword, int page, int size) {
        if (keyword != null && !keyword.isEmpty()) {
            return categoryRepository.findByNameContainingIgnoreCase(keyword, PageRequest.of(page, size));
        }
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category get(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
