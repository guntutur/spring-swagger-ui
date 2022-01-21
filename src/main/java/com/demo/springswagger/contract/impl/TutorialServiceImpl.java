package com.demo.springswagger.contract.impl;

import com.demo.springswagger.contract.service.TutorialService;
import com.demo.springswagger.data.entity.Tutorial;
import com.demo.springswagger.data.repository.TutorialRepository;
import com.demo.springswagger.mapper.request.TutorialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by zer0, the Maverick Hunter
 * on 21/01/22
 * Class: TutorialServiceImpl
 */
@Service
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Optional<TutorialRequest> findById(String id) {
        Optional<Tutorial> data = tutorialRepository.findById(id);
        if (data.isPresent()) {
            return data.map(TutorialRequest::of);
        }

        return Optional.empty();
    }

    @Override
    public List<TutorialRequest> findByTitleContaining(String search) {
        return tutorialRepository
                .findByTitleContaining(search)
                .stream()
                .map(TutorialRequest::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<TutorialRequest> findAll() {
        return tutorialRepository
                .findAll()
                .stream()
                .map(TutorialRequest::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<TutorialRequest> findByPublished() {
        return tutorialRepository
                .findByPublished(true)
                .stream()
                .map(TutorialRequest::of)
                .collect(Collectors.toList());
    }

    @Override
    public TutorialRequest save(TutorialRequest tutorial) {
        Tutorial save = new Tutorial();
        save.setTitle(tutorial.getTitle());
        save.setDescription(tutorial.getDescription());
        save.setCategory(tutorial.getCategory());
        save.setPublished(tutorial.isPublished());
        tutorialRepository.save(save);

        return TutorialRequest.of(save);
    }

    @Override
    public void deleteById(String id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialRepository.deleteAll();
    }
}
