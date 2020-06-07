package com.vvopaa.cloud.general.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Note {
    private long id;
    private String message;

    public Note(String message) {
        this.message = message;
    }

    public Note setIdFunctional(long id) {
        this.id = id;
        return this;
    }
}
