package com.vidlib.service.jpa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.vidlib.domain.Media;
import com.vidlib.domain.Property;
import com.vidlib.domain.Scene;
import com.vidlib.domain.Thumbnail;

import com.vidlib.service.SceneService;

public class SceneServiceTest extends AbstractServiceTest{

	@Autowired
	SceneService sceneService;
	
	@Test
	@DatabaseSetup("with_thumbs.xml")
	public void TestGetScene()
	{

		Scene scene = sceneService.find(1L);
		
		assertNotNull(scene);
	}
	
	@Test
	@DatabaseSetup("with_thumbs.xml")
	public void TestSceneThumbnails()
	{

		Scene scene = sceneService.find(1L);
		
		assertEquals(scene.getThumbnails().size(), 9);
	}
	
	@Test
	@DatabaseSetup("with_thumbs.xml")
	public void TestSceneMedia()
	{

		Scene scene = sceneService.find(1L);
		
		Long id = scene.getMedia().getId_media();
		
		assertEquals(1L, id);
	}
	
	
}
