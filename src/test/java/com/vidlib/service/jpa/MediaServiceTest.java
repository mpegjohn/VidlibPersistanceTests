package com.vidlib.service.jpa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.vidlib.domain.Media;
import com.vidlib.domain.Property;
import com.vidlib.domain.Scene;
import com.vidlib.service.MediaService;

public class MediaServiceTest extends AbstractServiceTest{

	@Autowired
	MediaService mediaService;
	
	@Test
	@Rollback(false)
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "first_media.xml")
	public void TestCreateMedia()
	{
		deleteFromTables("media", "property", "scene", "notes");
		Media media = new Media();
		media.setName("First media");
		//media.setImportDate(new Date(113,1,26,0,0,0));
		Calendar cal = new GregorianCalendar(2013, 0, 2,1,2,3);
		
		Date dt = cal.getTime();
		
		media.setImportDate(dt);
		
		mediaService.save(media);
		//em.flush();
		
		
//		Scene scene = new Scene();
//		scene.setSceneNumber(1);
		
//		media.addScene(scene);
//		mediaService.save(media);
		
		
		//Media savedMedia = mediaService.findById(1);
		
		//assertEquals("First media", savedMedia.getName());
		
		
	}

	@Test
	@Rollback(false)
	@DatabaseSetup("list_of_media.xml")
	public void TestFindAll()
	{
		List<Media> mediaList = mediaService.findAll();
		
		assertEquals(10, mediaList.size());
	}
	
	@Test
	@Rollback(false)
	@DatabaseSetup("first_media.xml")
	public void TestReadMedia()
	{
		Media media = mediaService.findById(1);
		assertEquals("First media", media.getName());
		
		Calendar cal = new GregorianCalendar(2013, 0, 2,1,2,3);
		
		Date act = media.getImportDate();
		
		Calendar actDt = new GregorianCalendar();
		actDt.setTime(act);
		
		assertEquals(cal,actDt);
	}
	
	@Test
	@Rollback(false)
	public void TestNoMedia()
	{
		deleteFromTables("media", "property", "scene", "notes");
		Media media = mediaService.findById(1);
		assertNull(media);
	}
}
