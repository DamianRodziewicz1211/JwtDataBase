package servicetest;

import com.jwtdatabase.repository.ArtistDao;
import com.jwtdatabase.service.ArtistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class ArtistServiceTest {

    @SpyBean
    private ArtistService artistService;

    @MockBean
    private ArtistDao artistRepository;

    private Integer trackId = 3;

    @Test
    public void should_add_artist_to_repository() throws Exception {
        String message = artistService.addArtist(trackId);
        System.out.println(message);
        //assertEquals("Album \"Toto IV\" has been added to favourites with id 0", message);

    }

    @Test
    public void should_remove_artist_from_repository() throws Exception {
        String message = artistService.addArtist(trackId);
        boolean isRemoved = artistService.deleteArtist(0l);

        assertTrue(isRemoved);
    }
}
