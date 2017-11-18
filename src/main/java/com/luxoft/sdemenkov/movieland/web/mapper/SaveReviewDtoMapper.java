package com.luxoft.sdemenkov.movieland.web.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.luxoft.sdemenkov.movieland.web.request.SaveReviewDTO;

import java.io.IOException;


public class SaveReviewDtoMapper extends JsonDeserializer<SaveReviewDTO> {

    @Override
    public SaveReviewDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        return new SaveReviewDTO()
                .setMovieId(jsonNode.get("movieId").asInt())
                .setText(jsonNode.get("movieId").asText());
    }
}
