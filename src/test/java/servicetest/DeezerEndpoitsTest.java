package servicetest;

import com.jwtdatabase.model.DAOAlbum;
import com.jwtdatabase.model.DAOArtist;
import com.jwtdatabase.model.DAOTrack;
import com.jwtdatabase.service.DeezerAPIEndpoints;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DeezerEndpoitsTest {

    private DeezerAPIEndpoints deezer = new DeezerAPIEndpoints();

    private final Integer trackId = 1079668;

    private final Integer albumId = 116670;

    private final Integer artistId = 215;



    @Test
    public void should_get_track() throws Exception{

            final DAOTrack track = deezer.searchTrack(trackId);
            Integer duration = 295;

            assertNotNull(track);
            assertEquals("Africa",track.getTitle());
            assertEquals("Toto",track.getArtist());
            assertEquals("Toto IV", track.getAlbum());
            assertEquals(duration,track.getDuration());
    }

    @Test
    public void should_get_album() throws Exception{

        final DAOAlbum album = deezer.searchAlbum(albumId);

        assertNotNull(album);
        assertEquals("Toto IV",album.getTitle());
        assertEquals("Toto",album.getArtist());
        assertEquals("Pop",album.getGenre());
        assertNotNull(album.getTracks());
    }

    @Test
    public void should_get_artist() throws Exception{

        final DAOArtist artist = deezer.searchArtist(artistId);
        Integer albums = 26;

        assertNotNull(artist);
        assertEquals("Toto",artist.getArtistName());
        assertEquals("artist",artist.getType());
        assertEquals(albums,artist.getNumberOfAlbums());
    }

    @Test
    public void should_get_query() throws Exception{

        final String response = deezer.search("eminem");

        assertNotNull(response);
        assertTrue(response.contains("Darkness"));
    }
}
