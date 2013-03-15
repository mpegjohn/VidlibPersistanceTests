package com.vidlib.service.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vidlib.domain.Scene;

public interface SceneRepository extends JpaRepository<Scene, Long> {

	public final static String FIND_BY_MEDIA_ID = "SELECT c"
			+ "FROM Contact c WHERE c.media.id_media = :id";
	
	public final static String FIND_BY_ID_LIST = "SELECT c"
			+ "FROM Contact c WHERE c.id_scene = :id";
	
	@Query(FIND_BY_MEDIA_ID)
	public List<Scene> findByMediaId(@Param("id") Long id, Pageable page);
	
	@Query(FIND_BY_ID_LIST)
	public List<Scene> findByIdList(@Param("id") List<Long> id, Pageable page);
}
