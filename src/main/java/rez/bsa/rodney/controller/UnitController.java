package rez.bsa.rodney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rez.bsa.rodney.domain.Scout;
import rez.bsa.rodney.domain.Unit;
import rez.bsa.rodney.repository.UnitRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/units")
public
class UnitController {

    private static final Logger logger = LoggerFactory.getLogger(UnitController.class);

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private ScoutController scoutController;
//
//    @Autowired
//    private LeaderController leaderController;

    @GetMapping(path = "/")
    public @ResponseBody
    List<Unit> findAll() {
        logger.info("get all units");
        return unitRepository.findAll();
    }

    @PostMapping(path = "/")
    public @ResponseBody
    Unit saveUnit(Unit unit) {
        logger.info("saving unit");
        for(Scout scout : unit.getScouts())
        {
            scout.setUnit(unit);
        }
        return unitRepository.save(unit);
    }
}
