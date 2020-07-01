package com.jwtdatabase.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jwtdatabase.model.DAOAlbum;

import java.io.IOException;

public class AlbumSerializer extends StdSerializer<DAOAlbum>  {

    public AlbumSerializer(){
        this(DAOAlbum.class);
    }

    private AlbumSerializer(Class<DAOAlbum> al){
        super(al);
    }

    @Override
    public void serialize(DAOAlbum album, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", album.getTitle());
        gen.writeStringField("genre", album.getGenre());
        gen.writeStringField("artist", album.getArtist());
        gen.writeObjectFieldStart("tracks");
        for (String key : album.getTracks().keySet()) {
            gen.writeStringField( key, album.getTracks().get(key));
        }
        gen.writeEndObject();

    }
}
