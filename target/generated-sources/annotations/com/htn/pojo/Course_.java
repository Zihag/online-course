package com.htn.pojo;

import com.htn.pojo.Category;
import com.htn.pojo.Document;
import com.htn.pojo.Enrollment;
import com.htn.pojo.Exercise;
import com.htn.pojo.Lecture;
import com.htn.pojo.Rating;
import com.htn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-04T22:51:35")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-03T23:21:39")
>>>>>>> 6d10d264148fc6acd9dbe117568ae120582bf321
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T00:18:55")
>>>>>>> 599719ce95487ee87a66dcdcd8f595f2bd148462
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> coverImg;
    public static volatile CollectionAttribute<Course, Enrollment> enrollmentCollection;
    public static volatile CollectionAttribute<Course, Document> documentCollection;
    public static volatile SingularAttribute<Course, String> description;
    public static volatile SingularAttribute<Course, Date> updateAt;
    public static volatile SingularAttribute<Course, String> title;
    public static volatile CollectionAttribute<Course, Rating> ratingCollection;
    public static volatile SingularAttribute<Course, Date> createdAt;
    public static volatile SingularAttribute<Course, User> teacher;
    public static volatile CollectionAttribute<Course, Lecture> lectureCollection;
    public static volatile CollectionAttribute<Course, Exercise> exerciseCollection;
    public static volatile SingularAttribute<Course, Double> price;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, Category> category;

}