package com.htn.pojo;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-04T22:51:35")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-03T23:21:39")
>>>>>>> 6d10d264148fc6acd9dbe117568ae120582bf321
@StaticMetamodel(Enrollment.class)
public class Enrollment_ { 

    public static volatile SingularAttribute<Enrollment, User> studentId;
    public static volatile SingularAttribute<Enrollment, Date> createdAt;
    public static volatile SingularAttribute<Enrollment, Date> completedAt;
    public static volatile SingularAttribute<Enrollment, BigDecimal> progress;
    public static volatile SingularAttribute<Enrollment, Integer> id;
    public static volatile SingularAttribute<Enrollment, Course> courseId;

}