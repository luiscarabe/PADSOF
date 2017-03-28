/**
 * 
 */
package es.uam.eps.padsof.p3.user.testers;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.stat.Answer;
import es.uam.eps.padsof.p3.stat.CMark;
import es.uam.eps.padsof.p3.user.Application;
import es.uam.eps.padsof.p3.user.Student;

/**
 * @author Alejo Luis
 *
 */
public class StudentTester {
	Student s;
	List<Answer> a;
	Answer a1;
	Exercise e;
	Application ap, ap2;
	Course c, c2, c4, c5;
	List<Course> c1;
	List<Course> c3;
	CMark cm;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new Student("David Prieto","David.Prieto@aadu.es","idPrieto");
		c = new Course("PADSOF", "Testing");
		c2 = new Course("CN", "Numbers and sets");
		c4 = new Course("LAB", "Java forever");
		c5 = new Course("ADSOF", "Like PADSOF but without P");
		e = new Exercise(c);
		a = new ArrayList<Answer>();
		a1 = new Answer(e, s, 5);
		a.add(a1);
		c1 = new ArrayList<Course>();
		c1.add(c);
		c3 = new ArrayList<Course>();
		c3.add(c2);
		ap = new Application(c5, s);
		cm = new CMark(c, s);
		cm.setCourseMark(9.3);
		
		s.setAnswers(a);
		
		s.setExpelledCourses(c1);
		
		s.setEnrolledCourses(c3);
		
		s.getAppliedCourses().add(ap);
		
		s.getcMarks().add(cm);
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#getAnswers()}.
	 */
	@Test
	public void testGetAnswers() {
		assertEquals(s.getAnswers(), a);
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#getExpelledCourses()}.
	 */
	@Test
	public void testGetExpelledCourses() {
		assertEquals(s.getExpelledCourses(), c1);
	}


	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#getEnrolledCourses()}.
	 */
	@Test
	public void testGetEnrolledCourses() {
		assertEquals(s.getEnrolledCourses(), c3);
	}


	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#applyCourse(es.uam.eps.padsof.p3.course.Course)}.
	 */
	@Test
	public void testApplyCourse() {
		assertFalse(s.applyCourse(c2));
		assertFalse(s.applyCourse(c));
		assertTrue(s.applyCourse(c4));
	}
	
	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#getAppliedCourses()}.
	 */
	@Test
	public void testGetAppliedCourses() {
		assertTrue(s.getAppliedCourses().contains(ap));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#cancelApplication(es.uam.eps.padsof.p3.user.Application)}.
	 */
	@Test
	public void testCancelApplication() {
		ap2 = c4.searchApplication(s);
		s.cancelApplication(ap2);
		assertFalse(s.getAppliedCourses().contains(ap2));
	}

	/**
	 * Test method for {@link es.uam.eps.padsof.p3.user.Student#seeCMark(es.uam.eps.padsof.p3.course.Course)}.
	 */
	@Test
	public void testSeeCMark() {
		assertTrue(s.seeCMark(c) == 9.3);
	}

}
