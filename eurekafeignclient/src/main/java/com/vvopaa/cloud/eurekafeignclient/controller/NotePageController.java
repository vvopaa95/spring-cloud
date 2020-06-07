package com.vvopaa.cloud.eurekafeignclient.controller;

import com.vvopaa.cloud.eurekafeignclient.feign.FeignNoteClient;
import com.vvopaa.cloud.general.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NotePageController {
    private final FeignNoteClient feignNoteClient;

    @GetMapping("/get/{id}")
    public String getNote(Model model, @PathVariable(value = "id", required = false) long id) {
        id = Optional.of(id).filter(currentId -> currentId > 0L).orElse(1L);
        Note note = feignNoteClient.getById(id);
        model.addAttribute("note", note);
        return "note-view";
    }
}
