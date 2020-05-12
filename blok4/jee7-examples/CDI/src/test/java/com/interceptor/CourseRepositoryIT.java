package com.interceptor;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.naming.NamingException;

@RunWith(Arquillian.class)
public class CourseRepositoryIT {
	@Inject
	private CourseRepository courseRepository;

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
				.addPackage(CourseRepository.class.getPackage())
				.addAsManifestResource(new StringAsset("<interceptors><class>com.interceptor.MethodDurationInterceptor</class></interceptors>"), "beans.xml");

		System.out.println(archive.toString(true));
		return archive;
	}


	@Test
	public void testInterceptor() throws NamingException, InterruptedException {
		courseRepository.save();
		courseRepository.retrieve();
	}
}
