package com.demo.springswagger.contract.service;

import com.demo.springswagger.mapper.request.TutorialRequest;

import java.util.List;
import java.util.Optional;

/**
 * Created by zer0, the Maverick Hunter
 * on 21/01/22
 * Class: TutorialService
 */
public interface TutorialService {

    Optional<TutorialRequest> findById(String id);
    List<TutorialRequest> findByTitleContaining(String search);
    List<TutorialRequest> findAll();
    List<TutorialRequest> findByPublished();
    TutorialRequest save(TutorialRequest tutorial);
    void deleteById(String id);
    void deleteAll();

}
