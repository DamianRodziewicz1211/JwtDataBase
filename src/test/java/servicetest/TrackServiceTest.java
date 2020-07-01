package servicetest;

import com.jwtdatabase.repository.TrackDao;
import com.jwtdatabase.service.TrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class TrackServiceTest {

    @SpyBean
    private TrackService trackService;

    @MockBean
    private TrackDao trackRepository;

    private Integer trackId = 1079668;

    @Test
    public void should_add_track_to_repository() throws Exception{
        String message = trackService.addTrack(trackId);
        assertEquals("Track \"Africa\" has been added to favourites with id 0", message);

    }

    @Test
    public void should_remove_track_from_repository() throws Exception{
        String message = trackService.addTrack(trackId);
        boolean isRemoved = trackService.deleteTrack(0l);

        assertTrue(isRemoved);
    }



}
