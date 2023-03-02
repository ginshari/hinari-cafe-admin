package net.hinaricafe.service;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.Coffee;
import net.hinaricafe.model.CoffeesPage;
import net.hinaricafe.repository.CoffeesPageRepository;
import net.hinaricafe.repository.CoffeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;


@Service
@RequiredArgsConstructor
public class CoffeesService {

    private final CoffeesPageRepository coffeesPageRepository;

    private final CoffeesRepository coffeesRepository;

    public CoffeesPage getCoffeesPage() {
        CoffeesPage coffeesPage = coffeesPageRepository.findOne();
        coffeesPage.getCoffees().sort(Comparator.comparing(Coffee::getPubDate).reversed());
        return coffeesPage;
    }

    public Coffee getCoffee(String objectId) {
        return coffeesRepository.findById(objectId).orElse(new Coffee());
    }

    @Transactional
    public void insertCoffee(Coffee coffee) {
        var newCoffee = new Coffee();
        newCoffee.setVideoId(coffee.getVideoId());
        newCoffee.setPubDate(coffee.getPubDate());
        newCoffee.setVideoTitle(coffee.getVideoTitle());
        newCoffee.setImgUrl(coffee.getImgUrl());
        newCoffee.setName(coffee.getName());
        newCoffee.setOrderTime(coffee.getOrderTime());
        newCoffee.setReviewTime(coffee.getReviewTime());
        newCoffee.setReviewText(coffee.getReviewText());
        newCoffee.setNote(coffee.getNote());
        coffeesRepository.save(newCoffee);

        CoffeesPage coffeesPage = coffeesPageRepository.findOne();
        coffeesPage.getCoffees().add(newCoffee);
        coffeesPageRepository.save(coffeesPage);
    }

    @Transactional
    public void updateCoffee(Coffee coffee) {
        coffeesRepository.save(coffee);
    }

}
