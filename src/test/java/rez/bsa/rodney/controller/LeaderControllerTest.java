package rez.bsa.rodney.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import rez.bsa.rodney.domain.Leader;
import rez.bsa.rodney.domain.Scout;
import rez.bsa.rodney.domain.Unit;
import rez.bsa.rodney.repository.LeaderRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeaderControllerTest {

    private LeaderController controller;
    private LeaderRepository leaderRepository;


    @BeforeEach
    public
    void setUp() throws Exception {
        controller = new LeaderController();
        leaderRepository = createMock(LeaderRepository.class);

        ReflectionTestUtils.setField(controller,
                                     "leaderRepository",
                                     leaderRepository);

    }

    private
    void replayAll() {
        replay(leaderRepository);
    }

    private
    void verifyAll() {
        verify(leaderRepository);
    }

    @Test
    public
    void getAllTest() {
        ArrayList<Leader> leaders = new ArrayList<>();
        expect(leaderRepository.findAll()).andReturn(leaders);
        replayAll();


        List<Leader> response = controller.findAll();
        verifyAll();

        assertEquals(0,
                     response.size());
    }

    @Test
    void createScout() {
        Scout s = Scout.builder().firstName("Michael").lastName("Radaszkiewicz").build();
        Leader leader = Leader.builder().firstName("Casey").lastName("Radaszkiewicz").build();
        Set<Scout> scouts = new HashSet<>();
        scouts.add(s);
        Unit unit = Unit.builder().unitNumber("29").scouts(scouts).build();
        expect(leaderRepository.save(leader)).andReturn(leader);
        replayAll();
        Leader response = controller.saveLeader(leader);
        verifyAll();

        assertEquals(leader,
                     response);
    }

}
