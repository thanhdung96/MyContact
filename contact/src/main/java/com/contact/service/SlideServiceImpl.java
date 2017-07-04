package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.domain.Slide;
import com.contact.repository.SlideRepository;

@Service
public class SlideServiceImpl implements SlideService {

	@Autowired
	private SlideRepository slideRepository;

	@Override
	public Iterable<Slide> findAll() {
		return slideRepository.findAll();
	}

	@Override
	public Slide findOne(int id) {
		return slideRepository.findOne(id);
	}

	@Override
	public void save(Slide slide) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		slideRepository.delete(id);
	}

}
