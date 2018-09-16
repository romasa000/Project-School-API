package org.projectschool.school.core.eis.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "office_assignment")
public class OfficeAssignment implements Serializable {
    @Id
    @Column(name = "instructor_id")
    private Long instructorId;
    @Column(name = "location")
    private String location;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore //Importante
    @JoinColumn(name = "instructor_id",referencedColumnName = "person_id",nullable = false)
    private Person person;
}
