package com.contact.service;

import com.contact.domain.Slide;

public interface SlideService {
	Iterable<Slide> findAll();

	Slide findOne(int id);

	void save(Slide slide);

	void delete(int id);
}
