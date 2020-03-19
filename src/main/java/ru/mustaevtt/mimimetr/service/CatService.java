package ru.mustaevtt.mimimetr.service;


import ru.mustaevtt.mimimetr.dto.CatDto;
import ru.mustaevtt.mimimetr.model.Cat;

import java.util.List;
import java.util.Queue;

public interface CatService {
    Queue<Cat> findAllByRand();

    Iterable<Cat> findAll();

    List<CatDto> getTop10Cats();

    List<CatDto> getPairCats();
}
