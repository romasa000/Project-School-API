package org.projectschool.school.core.eis.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private Double budget;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "administrador")
    private Integer administrador;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Course> courses;
}
