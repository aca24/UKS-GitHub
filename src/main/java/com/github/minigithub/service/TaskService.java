package com.github.minigithub.service;

import com.github.minigithub.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
	private TaskRepository taskRepository;

    
}
