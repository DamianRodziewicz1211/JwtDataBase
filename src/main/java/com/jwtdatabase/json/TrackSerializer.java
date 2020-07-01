package com.jwtdatabase.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jwtdatabase.model.DAOTrack;

import java.io.IOException;


public class TrackSerializer extends StdSerializer<DAOTrack> {

    public TrackSerializer(){
        this(DAOTrack.class);
    }

    private TrackSerializer(Class<DAOTrack> tr){
        super(tr);
    }

    @Override
    public void serialize(
            DAOTrack track, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", track.getTitle());
        gen.writeStringField("album", track.getAlbum());
        gen.writeStringField("artist", track.getArtist());
        gen.writeNumberField("duration", track.getDuration());
        gen.writeEndObject();
    }

}
