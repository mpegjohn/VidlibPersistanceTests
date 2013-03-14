package com.vidlib.service;

import org.springframework.transaction.annotation.Transactional;

import com.vidlib.domain.Scene;

public interface SceneService {

	@Transactional(readOnly = true)
	public abstract Scene find(long id);

}