package rez.bsa.rodney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rez.bsa.rodney.domain.Leader;
import rez.bsa.rodney.domain.MeritBadge;
import rez.bsa.rodney.domain.Requirement;
import rez.bsa.rodney.domain.Scout;
import rez.bsa.rodney.domain.Unit;
import rez.bsa.rodney.repository.MeritBadgeRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(path = "/alive")
public
class AliveController {

    private static final Logger logger = LoggerFactory.getLogger(AliveController.class);

    @Autowired
    ScoutController scoutController;
    @Autowired
    UnitController unitController;
    @Autowired
    LeaderController leaderController;
    @Autowired
    MeritBadgeRepository meritBadgeRepository;

    @GetMapping(path = "/")
    public @ResponseBody
    boolean isAlive() {
        logger.info("checking is alive");
        return true;
    }

    @GetMapping(path = "/mockData")
    public @ResponseBody
    Unit mockData() {
        logger.info("setting up mock data");


        Leader leader = Leader.builder().firstName("Casey").lastName("Radaszkiewicz").build();


        Scout s = Scout.builder().firstName("Michael").lastName("Radaszkiewicz").build();
        Set<Scout> scouts = new HashSet<>();
        scouts.add(s);
        Unit unit = Unit.builder().unitNumber("29").scouts(scouts).leader(leader).build();

        MeritBadge climbing = new MeritBadge();
        climbing.setName("climing");
        Set<Requirement> requirements = new HashSet<>();
        requirements.add(Requirement.builder().requirementNumber("1a").requirementText("Explain to your counselor the most likely hazards you may encounter while participating in climbing and rappelling activities and what you should do to anticipate, help prevent, mitigate, and respond to these hazards.").build());
        requirements.add(Requirement.builder().requirementNumber("1b").requirementText("Show that you know first aid for and how to prevent injuries or illnesses that could occur during climbing activities, including heat and cold reactions, dehydration, stopped breathing, sprains, abrasions, fractures, rope burns, blisters, snakebite, and insect bites or stings.").build());
        requirements.add(Requirement.builder().requirementNumber("1c").requirementText("Identify the conditions that must exist before performing CPR on a person.").build());
        requirements.add(Requirement.builder().requirementNumber("2").requirementText("Learn the Leave No Trace principles and Outdoor Code, and explain what they mean.").build());
        requirements.add(Requirement.builder().requirementNumber("3").requirementText("Present yourself properly dressed for belaying, climbing, and rappelling (i.e., appropriate clothing, footwear, and a helmet; rappellers can also wear gloves).").build());
        climbing.setRequirements(requirements);
        for(Requirement r: climbing.getRequirements())
        {
            r.setMeritBadge(climbing);
        }
        meritBadgeRepository.save(climbing);
        return unitController.saveUnit(unit);
    }
}
