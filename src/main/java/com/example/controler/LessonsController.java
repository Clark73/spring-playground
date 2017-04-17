package com.example.controler;

import com.example.entity.Lesson;
import com.example.entity.LessonRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kevin Clark.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}
