package com.inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class CourseServiceIT {
	@Inject
	private CourseService courseService;

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class)
				.addPackage(CourseService.class.getPackage());
		System.out.println(archive.toString(true));
		return archive;
	}

	@Test
	public void testGetStudents() throws Exception {
		assertEquals(courseService.retrieveTrainerForCourse(1).getName(), "Ann");
	}
}
