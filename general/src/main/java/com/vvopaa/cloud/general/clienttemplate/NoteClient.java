package com.vvopaa.cloud.general.clienttemplate;

import com.vvopaa.cloud.general.model.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

public interface NoteClient {

    @GetMapping("/{id}}")
    Note getById(@PathVariable(name = "id") long id);

    @GetMapping
    Collection<Note> getAll();

    @PostMapping("/save")
    Note save(Note note);

    @PostMapping("/delete")
    boolean deleteAll();
}
