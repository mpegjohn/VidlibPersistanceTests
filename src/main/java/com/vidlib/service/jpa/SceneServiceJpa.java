package com.vidlib.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vidlib.domain.Scene;
import com.vidlib.service.SceneService;

@Service("jpaSceneService")
@Repository
@Transactional
public class SceneServiceJpa implements SceneService {

	@PersistenceContext
	private EntityManager em;
	
	
	/* (non-Javadoc)
	 * @see com.vidlib.service.jpa.Scene#find(long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Scene find(long id)
	{
		Scene scene = em.find(Scene.class, id);
		return scene;
	}

	
}
