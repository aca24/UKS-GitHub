package com.github.minigithub.service.implementation;

import java.util.List;

import com.github.minigithub.model.LabelApplication;
import com.github.minigithub.repository.LabelApplicationRepository;
import com.github.minigithub.service.LabelApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LabelApplicationServiceImplementation implements LabelApplicationService {

    private LabelApplicationRepository labelApplicationRepository;

    @Autowired
    public LabelApplicationServiceImplementation(LabelApplicationRepository labelApplicationRepository) {
        this.labelApplicationRepository = labelApplicationRepository;
    }

    public LabelApplication findOne(Long id) {
        return labelApplicationRepository.findById(id).orElseGet(null);
    }

    public List<LabelApplication> findAll() {
        return labelApplicationRepository.findAll();
    }

    public Page<LabelApplication> findAll(Pageable page) {
        return labelApplicationRepository.findAll(page);
    }

    public LabelApplication save(LabelApplication labelApplication) {
        return labelApplicationRepository.save(labelApplication);
    }

    public void remove(Long id) {
        labelApplicationRepository.deleteById(id);
    }
}