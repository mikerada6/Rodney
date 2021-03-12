package rez.bsa.rodney.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import rez.bsa.rodney.domain.Leader;
import rez.bsa.rodney.domain.Scout;
import rez.bsa.rodney.domain.Unit;
import rez.bsa.rodney.repository.UnitRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.*;

class UnitControllerTest {
    private UnitController controller;
    private UnitRepository unitRepository;


    @BeforeEach
    public
    void setUp() throws Exception {
        controller = new UnitController();
        unitRepository = createMock(UnitRepository.class);

        ReflectionTestUtils.setField(controller,
                                     "unitRepository",
                                     unitRepository);

    }

    private
    void replayAll() {
        replay(unitRepository);
    }

    private
    void verifyAll() {
        verify(unitRepository);
    }

    @Test
    public
    void getAllTest() {
        ArrayList<Unit> units = new ArrayList<>();
        expect(unitRepository.findAll()).andReturn(units);
        replayAll();


        List<Unit> response = controller.findAll();
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
        expect(unitRepository.save(unit)).andReturn(unit);
        replayAll();
        Unit response = controller.saveUnit(unit);
        verifyAll();

        assertEquals(unit,
                     response);
    }
}
