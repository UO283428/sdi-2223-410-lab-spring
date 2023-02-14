package com.uniovi.notaneditor.repositories;
import com.uniovi.notaneditor.entities.Mark;
import org.springframework.data.repository.CrudRepository;
public interface MarksRepository extends CrudRepository<Mark, Long> {
}
