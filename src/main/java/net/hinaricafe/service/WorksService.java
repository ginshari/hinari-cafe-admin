package net.hinaricafe.service;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.Event;
import net.hinaricafe.model.Link;
import net.hinaricafe.model.Profile;
import net.hinaricafe.model.WorksPage;
import net.hinaricafe.repository.EventsRepository;
import net.hinaricafe.repository.LinksRepository;
import net.hinaricafe.repository.ProfilesRepository;
import net.hinaricafe.repository.WorksPageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;


@Service
@RequiredArgsConstructor
public class WorksService {

    private final WorksPageRepository worksPageRepository;

    private final LinksRepository linksRepository;

    private final ProfilesRepository profilesRepository;

    private final EventsRepository eventsRepository;

    public WorksPage getWorksPage() {
        WorksPage worksPage = worksPageRepository.findOne();
        worksPage.getLinks().sort(Comparator.comparing(Link::getOrder));
        worksPage.getProfiles().sort(Comparator.comparing(Profile::getOrder));
        worksPage.getEvents().sort(Comparator.comparing(Event::getYyyymm).reversed());
        return worksPage;
    }

    public Link getLink(String objectId) {
        return linksRepository.findById(objectId).orElse(new Link());
    }

    @Transactional
    public void insertLink(Link link) {
        var newLink = new Link();
        newLink.setOrder(link.getOrder());
        newLink.setText(link.getText());
        newLink.setUrl(link.getUrl());
        linksRepository.save(newLink);

        WorksPage worksPage = worksPageRepository.findOne();
        worksPage.getLinks().add(newLink);
        worksPageRepository.save(worksPage);
    }

    @Transactional
    public void updateLink(Link link) {
        linksRepository.save(link);
    }

    public Profile getProfile(String objectId) {
        return profilesRepository.findById(objectId).orElse(new Profile());
    }

    @Transactional
    public void insertProfile(Profile profile) {
        var newProfile = new Profile();
        newProfile.setOrder(profile.getOrder());
        newProfile.setHead(profile.getHead());
        newProfile.setBody(profile.getBody());
        profilesRepository.save(newProfile);

        WorksPage worksPage = worksPageRepository.findOne();
        worksPage.getProfiles().add(newProfile);
        worksPageRepository.save(worksPage);
    }

    @Transactional
    public void updateProfile(Profile profile) {
        profilesRepository.save(profile);
    }

    public Event getEvent(String objectId) {
        return eventsRepository.findById(objectId).orElse(new Event());
    }

    @Transactional
    public void insertEvent(Event event) {
        var newEvent = new Event();
        newEvent.setYyyymm(event.getYyyymm());
        newEvent.setBranchNumber(event.getBranchNumber());
        newEvent.setCategory(event.getCategory());
        newEvent.setName(event.getName());
        newEvent.setUrl(event.getUrl());
        eventsRepository.save(newEvent);

        WorksPage worksPage = worksPageRepository.findOne();
        worksPage.getEvents().add(newEvent);
        worksPageRepository.save(worksPage);
    }

    @Transactional
    public void updateEvent(Event event) {
        eventsRepository.save(event);
    }

}
