package de.jjjannik.entities.basic;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Parent class for all data entities used in this API
 */
@Getter
@RequiredArgsConstructor
public abstract class DataEntity {
    private final JsonObject jsonObject;
}