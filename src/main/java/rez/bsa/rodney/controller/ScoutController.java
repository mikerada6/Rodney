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
import rez.bsa.rodney.repository.ScoutRepository;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/scouts")
public
class ScoutController {

    private static final Logger logger = LoggerFactory.getLogger(ScoutController.class);

    @Autowired
    private ScoutRepository scoutRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    List<Scout> findAll() {
        logger.info("get all scouts");
        return scoutRepository.findAll();
    }

    @PostMapping(path = "/")
    public @ResponseBody
    Scout saveScout(Scout scout) {
        logger.info("saving scout");
        return scoutRepository.save(scout);
    }

    @PostMapping(path = "/saveBatch")
    public @ResponseBody
    Iterable<Scout> saveAll(Set<Scout> scouts) {
        logger.info("saving scout");
        return scoutRepository.saveAll(scouts);
    }


}
