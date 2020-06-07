package com.vvopaa.cloud.eurekaclient.controller;

import com.vvopaa.cloud.eurekaclient.repository.NoteRepository;
import com.vvopaa.cloud.general.clienttemplate.NoteClient;
import com.vvopaa.cloud.general.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class NoteController implements NoteClient {
    private final NoteRepository repository;

    @Override
    public Note getById(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Note> getAll() {
        return repository.getAll();
    }

    @Override
    public Note save(Note note) {
        return repository.save(note);
    }

    @Override
    public boolean deleteAll() {
        repository.deleteAll();
        return true;
    }
}
