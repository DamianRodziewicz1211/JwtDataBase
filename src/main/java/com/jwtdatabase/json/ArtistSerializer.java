package com.jwtdatabase.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jwtdatabase.model.DAOArtist;

import java.io.IOException;


public class ArtistSerializer extends StdSerializer<DAOArtist> {


    public ArtistSerializer() {
        this(DAOArtist.class);
    }

    private ArtistSerializer(Class<DAOArtist> ar){
        super(ar);
    }

    @Override
    public void serialize(DAOArtist artist, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", artist.getArtistName());
        gen.writeNumberField("numberOfAlbums", artist.getNumberOfAlbums());
        gen.writeNumberField("numberOfFans", artist.getNumberOfFans());
        gen.writeStringField("type:", artist.getType());
        gen.writeEndObject();
    }
}
