package com.everwell.userservice.models.db;

import com.everwell.userservice.models.dtos.AddUserRequest;
import com.everwell.userservice.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @Column
    @SequenceGenerator(name="pk_sequence_users",sequenceName="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_sequence_users")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(length = 20)
    private String gender;

    @Column(columnDefinition = "date")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date dateOfBirth;

    @Column(length = 30)
    private String language;

    @Column(columnDefinition = "text")
    private String address;

    @Column
    private Long addedBy;

    @Column(length = 30)
    private String addedByType;

    @Column
    private String fatherName;

    @Column
    private Integer pincode;

    @Column(length = 100)
    private String city;

    @Column(length = 64)
    private String maritalStatus;

    @Column(length = 64)
    private String socioEconomicStatus;

    @Column
    private String keyPopulation;

    @Column
    private Integer height;

    @Column
    private Integer weight;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date createdAt;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date updatedAt;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date deletedAt;

    @Column
    private boolean isDeleted;

    @Column
    private Long deletedBy;

    @Column(length = 30)
    private String deletedByType;

    @Column
    private boolean dataConsent;

    @Column
    private Long clientId;
    
    @Column
    private String occupation;
   
    private static Logger LOGGER = LoggerFactory.getLogger(User.class);

    public User(AddUserRequest addUserRequest) throws ParseException
    {
        this.firstName = addUserRequest.getFirstName();
        this.lastName = addUserRequest.getLastName();
        this.address = addUserRequest.getAddress();
        this.gender = addUserRequest.getGender();
        this.language = addUserRequest.getLanguage();
        this.addedBy = addUserRequest.getAddedBy();
        this.addedByType = addUserRequest.getAddedByType();
        this.fatherName = addUserRequest.getFatherName();
        this.city = addUserRequest.getCity();
        this.pincode = addUserRequest.getPincode();
        this.maritalStatus = addUserRequest.getMaritalStatus();
        this.socioEconomicStatus = addUserRequest.getSocioEconomicStatus();
        this.keyPopulation = addUserRequest.getKeyPopulation();
        this.height = addUserRequest.getHeight();
        this.weight = addUserRequest.getWeight();
        this.occupation = addUserRequest.getOccupation();
        if(null != addUserRequest.getDateOfBirth())
        {
            this.dateOfBirth = Utils.convertStringToDate(addUserRequest.getDateOfBirth(), "yyyy-MM-dd");
        }
    }

    public User(AddUserRequest addUserRequest, Long clientId) throws ParseException {
        this(addUserRequest);
        this.clientId = clientId;
    }
}
