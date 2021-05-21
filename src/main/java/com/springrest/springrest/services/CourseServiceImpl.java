package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDAO;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{

	//List<Course> list =null;

	@Autowired
	private CourseDAO courseDAO;

	public CourseServiceImpl()
	{
		//        Course course = new Course(121,"Java","Java 8 basic description");
		//        list = new ArrayList<Course>();
		//        list.add(course);
		//        list.add(new Course(126,"C++" , "Learn C++ programming"));
	}

	@Override
	public List<Course> getCourses()
	{
		return courseDAO.findAll();
	}

	@Override
	public Course getCourse(long id)
	{
		//        Course c =null;
		//        for(Course course:list){
		//            if(course.getId()==id){
		//                c=course;
		//                break;
		//            }
		//
		//        }
		//Course entity=courseDAO.getOne(id);
		//return entity;
		List<Course> courses = courseDAO.findAll();
		Course ctr = null;
		for (Course c : courses)
		{
			if (c.getId() == id)
			{
				ctr = c;
				break;
			}
		}
		return ctr;
	}

	@Override
	public Course addCourse(Course course)
	{
		return courseDAO.save(course);
		//        list.add(course);

	}

	@Override
	public Course updateCourse(Course course)
	{
		//       for(Course e:list){
		//           if (e.getId()==course.getId()){
		//               e.setTitle(course.getTitle());
		//               e.setDescription(course.getDescription());
		//           }
		//       }
		return courseDAO.save(course);
	}

	@Override
	public Course deleteCourse(long id)
	{
		//        Course ct=null;
		//       for(Course c:list){
		//           if(c.getId()==id){
		//                ct=c;
		//               list.remove(c);
		//           }
		//        }
		Course entity = courseDAO.getOne(id);
		courseDAO.delete(entity);
		return entity;
	}
}
