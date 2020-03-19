package ru.mustaevtt.mimimetr.converter;

import org.springframework.stereotype.Component;
import ru.mustaevtt.mimimetr.dto.CatDto;
import ru.mustaevtt.mimimetr.model.Cat;
import ru.mustaevtt.mimimetr.util.Util;

import java.util.ArrayList;
import java.util.List;


@Component
public class DtoConverter {
    public CatDto getCatDtoFromCat(Cat cat) {
        String imageInBase64 = Util.decodeBytesToStringBase64(cat.getImageBytes());
        return new CatDto(cat.getId(), cat.getName(), imageInBase64);
    }
    public List<CatDto> getCatDtoList(Iterable<Cat> cats) {
        List<CatDto> catDtoList = new ArrayList<>();
        for (Cat cat : cats) {
            catDtoList.add(getCatDtoFromCat(cat));
        }
        return catDtoList;
    }
}
