package com.vvopaa.cloud.eurekaclient.repository;

import com.vvopaa.cloud.general.model.Note;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Repository
public class NoteRepository {
    private final AtomicLong idGenerator = new AtomicLong();
    private final Map<Long, Note> noteDb = new ConcurrentHashMap<>();

    @PostConstruct
    void init() {
        IntStream.rangeClosed(1, 10).boxed().forEach(integer -> save(new Note(UUID.randomUUID().toString())));
    }

    public Note save(Note note) {
        note = Optional.of(note)
                .filter(currentNote -> currentNote.getId() == 0)
                .map(currentNote -> currentNote.setIdFunctional(idGenerator.incrementAndGet()))
                .orElse(note);
        noteDb.put(note.getId(), note);
        return note;
    }

    public Note get(long id) {
        return noteDb.get(id);
    }

    public Collection<Note> getAll() {
        return noteDb.values();
    }

    public void deleteAll() {
        noteDb.clear();
    }
}
