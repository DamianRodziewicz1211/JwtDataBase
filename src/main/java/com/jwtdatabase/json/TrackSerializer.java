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
        gen.writeNumberField("trackId", track.getTrackId());
        gen.writeStringField("title", track.getTitle());
        gen.writeStringField("album", track.getAlbum());
        gen.writeStringField("artist", track.getArtist());
        gen.writeNumberField("duration", track.getDuration());
        gen.writeStringField("preview", track.getPreview());
        gen.writeStringField("cover", track.getCover());
        gen.writeNumberField("deezerId", track.getDeezerId());
        gen.writeEndObject();
    }

}
