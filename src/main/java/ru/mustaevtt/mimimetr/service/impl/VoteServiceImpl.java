package ru.mustaevtt.mimimetr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mustaevtt.mimimetr.model.Cat;
import ru.mustaevtt.mimimetr.model.Vote;
import ru.mustaevtt.mimimetr.repository.CatRepository;
import ru.mustaevtt.mimimetr.repository.VoteRepository;
import ru.mustaevtt.mimimetr.service.VoteService;


@Component
public class VoteServiceImpl implements VoteService {
    private CatRepository catRepository;
    private VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(CatRepository catRepository, VoteRepository voteRepository) {
        this.catRepository = catRepository;
        this.voteRepository = voteRepository;
    }

    @Override
    public void save(Long catId) {
        Vote vote = new Vote();
        vote.setCat(catRepository.findById(catId).orElse(new Cat()));
        voteRepository.save(vote);
    }
}
