package com.vidlib.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vidlib.domain.Scene;

public interface SceneService {

	@Transactional(readOnly = true)
	public abstract Scene find(long id);
	
	@Transactional(readOnly=true)
	public abstract List<Scene> FindByMediaId(long id);

	@Transactional(readOnly=true)
	public abstract List<Scene> FindByIdScene(List<Long> id);

	@Transactional(readOnly=true)
	public abstract List<Scene> FindByMediaIdPageable(long id);

	@Transactional(readOnly=true)
	public abstract List<Scene> FindByIdScenePageable(List<Long> id);

	
}