package servicetest;

import com.jwtdatabase.repository.AlbumDao;
import com.jwtdatabase.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class AlbumServiceTest {

    @SpyBean
    private AlbumService albumService;

    @MockBean
    private AlbumDao albumRepository;

    @Test
    public void should_add_album_to_repository() throws Exception{
        String message = albumService.addAlbum(116670);

        assertEquals("Album \"Toto IV\" has been added to favourites with id 0", message);

    }

    @Test
    public void should_remove_album_from_repository() throws Exception{
        String message = albumService.addAlbum(116670);
        boolean isRemoved = albumService.deleteAlbum(0l);

        assertTrue(isRemoved);
    }

}
