package com.powergroup.model.service;
import com.powergroup.model.table.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image findById(int id);
    List<Image> findByItemId(int itemId);
    int deleteByItemId(int itemId);

}
