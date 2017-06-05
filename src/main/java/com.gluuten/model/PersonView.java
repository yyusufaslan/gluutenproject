package com.gluuten.model;

import com.gluuten.domain.Person;
import com.gluuten.service.ImageService;
import lombok.Getter;
import lombok.ToString;
import com.gluuten.security.SecurityUtils;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 1.06.2017.
 */
@Getter
@ToString
public class PersonView implements Serializable {

    private Long id;
    private String personImage;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String about;
    private String city;
    private String phone;
    private Date birthDate;
    private String gender;
    private Date created;

    public PersonView(Person person)
    {
       final Person profile = SecurityUtils.currentProfile();

        this.id = person.getId();
        this.firstName=person.getFirstName();
        this.lastName=person.getLastName();
        this.userName=person.getUserName();
        this.email=person.getEmail();
        this.about=person.getAbout();
        this.city=person.getCity();
        this.phone=person.getPhone();
        this.birthDate=person.getBirthDate();
        this.gender=person.getGender().toString();
        this.created=person.getCreated();
        this.personImage =person.getPersonImage();
     //   this.image= ImageService.getImage(person.getId(), person.getUserName());
    }



}
