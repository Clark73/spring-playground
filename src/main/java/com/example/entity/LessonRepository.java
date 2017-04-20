package com.example.entity;

import com.example.entity.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);

}