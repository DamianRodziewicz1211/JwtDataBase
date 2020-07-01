package servicetest;

import com.jwtdatabase.repository.PlaylistDao;
import com.jwtdatabase.service.PlaylistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class PlaylistServiceTest {

    @SpyBean
    private PlaylistService playlistService;

    @MockBean
    private PlaylistDao playlistRepository;

    private Integer trackId = 1079668;

    @Test
    public void should_create_playlist_and_return_its_id() throws Exception {
        long id = playlistService.createPlaylist("test", "test");

        assertEquals(0l,id);
    }

    @Test
    public void should_remove_artist_from_repository() throws Exception {
        long id = playlistService.createPlaylist("test", "test");
        boolean isRemoved = playlistService.deletePlaylist(id);

        assertTrue(isRemoved);
    }
}