package com.vidlib.top;

import com.vidlib.service.*;
import com.vidlib.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;


public class Top {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("dev");
		ctx.load("classpath:app-context.xml");
		ctx.refresh();

		MediaService mediaService = ctx.getBean(
				"jpaMediaService", MediaService.class);

		/*
		List<Media> mediaList = mediaService.findAll();
		
		for(Media media : mediaList)
		{
			System.out.println(media.getName() + " " + media.getImportDate() + " " + media.getComment());
		}
		
		
		
		Media media = mediaService.find(1l);
		
		for(Scene scene : media.getScenes())
		{
			System.out.println(scene.getSceneNumber());
		}
		
		media = mediaService.find(26);
		
		*/
		
		Media media = new Media();
		media.setName("First media");
		
		Scene scene = new Scene();
		scene.setSceneNumber(122);
		
		Property property = new Property();
		property.setFileCreateDate(new Date());
		property.setFileExtension("ext");
		property.setFileName("fred");
		property.setFullFilename("fredrick");
		
		scene.addProperty(property);
		
		media.addScene(scene);
		scene = new Scene();
		scene.setSceneNumber(123);
		media.addScene(scene);
		mediaService.save(media);
		
		/*
		Contact contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111");
		contact.addContactTelDetail(contactTelDetail);
		contactTelDetail = new ContactTelDetail("Mobile", "222222");
		contact.addContactTelDetail(contactTelDetail);
		
		mediaService.save(contact);
		*/
	}
}
