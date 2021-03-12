package rez.bsa.rodney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rez.bsa.rodney.domain.Leader;
import rez.bsa.rodney.repository.LeaderRepository;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/leaders")
public
class LeaderController {

    private static final Logger logger = LoggerFactory.getLogger(LeaderController.class);

    @Autowired
    private LeaderRepository leaderRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    List<Leader> findAll() {
        logger.info("get all leaders");
        return leaderRepository.findAll();
    }

    @PostMapping(path = "/")
    public @ResponseBody
    Leader saveLeader(Leader leader) {
        logger.info("saving unileaderst");
        return leaderRepository.save(leader);
    }

    @PostMapping(path = "/batchSave")
    public @ResponseBody
    Iterable<Leader> saveAll(Set<Leader> leader) {
        logger.info("saving leader");
        return leaderRepository.saveAll(leader);
    }
}
