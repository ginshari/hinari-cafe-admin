package net.hinaricafe.service;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.LandingPage;
import net.hinaricafe.model.LpItem;
import net.hinaricafe.repository.LandingPageRepository;
import net.hinaricafe.repository.LpItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;


@Service
@RequiredArgsConstructor
public class LandingService {

    private final LandingPageRepository landingPageRepository;

    private final LpItemRepository lpItemRepository;

    public LandingPage getLandingPage() {
        LandingPage landingPage = landingPageRepository.findOne();
        landingPage.getWorks().sort(Comparator.comparing(LpItem::getOrder));
        landingPage.getRecommends().sort(Comparator.comparing(LpItem::getOrder));
        landingPage.getCoffees().sort(Comparator.comparing(LpItem::getOrder));
        return landingPage;
    }

    public LpItem getLpItem(String objectId) {
        return lpItemRepository.findById(objectId).orElse(new LpItem());
    }

    @Transactional
    public void updateLandingPage(LandingPage landingPage) {
        LandingPage newLandingPage = landingPageRepository.findOne();
        newLandingPage.setGreeting(landingPage.getGreeting());
        newLandingPage.setAnnotation(landingPage.getAnnotation());
        landingPageRepository.save(newLandingPage);
    }

    @Transactional
    public void insertLpItem(LpItem lpItem) {
        var newLpItem = new LpItem();
        newLpItem.setCategory(lpItem.getCategory());
        newLpItem.setOrder(lpItem.getOrder());
        newLpItem.setUrl(lpItem.getUrl());
        newLpItem.setImgUrl(lpItem.getImgUrl());
        newLpItem.setHead(lpItem.getHead());
        newLpItem.setBody(lpItem.getBody());
        lpItemRepository.save(newLpItem);

        LandingPage landingPage = landingPageRepository.findOne();

        switch (newLpItem.getCategory()) {
            case "works" -> landingPage.getWorks().add(newLpItem);
            case "recommends" -> landingPage.getRecommends().add(newLpItem);
            case "coffees" -> landingPage.getCoffees().add(newLpItem);
        }
        landingPageRepository.save(landingPage);
    }

    @Transactional
    public void updateLpItem(LpItem lpItem) {
        lpItemRepository.save(lpItem);
    }

}
