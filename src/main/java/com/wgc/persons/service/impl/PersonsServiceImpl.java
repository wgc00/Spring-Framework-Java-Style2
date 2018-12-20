package com.wgc.persons.service.impl;

import com.wgc.persons.dao.PersonsMapper;
import com.wgc.persons.entity.Persons;
import com.wgc.persons.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    private PersonsMapper mapper;

    @Override
    public List<Persons> all() {
        return mapper.selectAll();
    }
}
