package com.vidlib.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidlib.domain.Scene;

@Service("jpaSceneService")
@Repository
@Transactional
public class SceneService {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(readOnly=true)
	public Scene find(long id)
	{
		Scene scene = em.find(Scene.class, id);
		return scene;
	}

	
}
