package com.jwtdatabase.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jwtdatabase.model.DAOPlaylist;

import java.io.IOException;

public class PlaylistSerializer extends StdSerializer<DAOPlaylist> {

    public PlaylistSerializer(){
        this(DAOPlaylist.class);
    }

    private PlaylistSerializer(Class<DAOPlaylist> pl){
        super(pl);
    }

    @Override
    public void serialize(DAOPlaylist playlist, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", playlist.getPlaylistTitle());
        gen.writeStringField("description", playlist.getDescription());
        gen.writeObjectFieldStart("tracks");
        for(Integer key: playlist.getPlaylistTracks().keySet()) {
            gen.writeStringField(key.toString(), playlist.getPlaylistTracks().get(key));
        }
        gen.writeEndObject();


    }
}
