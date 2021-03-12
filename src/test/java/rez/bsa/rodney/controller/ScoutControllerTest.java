package rez.bsa.rodney.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import rez.bsa.rodney.domain.Scout;
import rez.bsa.rodney.repository.ScoutRepository;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoutControllerTest {
    private ScoutController controller;
    private ScoutRepository scoutRepository;


    @BeforeEach
    public
    void setUp() throws Exception {
        controller = new ScoutController();
        scoutRepository = createMock(ScoutRepository.class);

        ReflectionTestUtils.setField(controller,
                                     "scoutRepository",
                                     scoutRepository);

    }

    private
    void replayAll() {
        replay(scoutRepository);
    }

    private
    void verifyAll() {
        verify(scoutRepository);
    }

    @Test
    public
    void getAllTest() {
        ArrayList<Scout> scouts = new ArrayList<>();
        expect(scoutRepository.findAll()).andReturn(scouts);
        replayAll();


        List<Scout> response = controller.findAll();
        verifyAll();

        assertEquals(0,
                     response.size());
    }

    @Test
    void createScout() {
        Scout s = Scout.builder().firstName("Michael").lastName("Radaszkiewicz").build();
        expect(scoutRepository.save(s)).andReturn(s);
        replayAll();
        Scout response = controller.saveScout(s);
        verifyAll();

        assertEquals(s,
                     response);
    }
}
