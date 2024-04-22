package com.sci.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Departments", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "dep_gen", sequenceName = "departments_seq", allocationSize = 1)
public class Departments implements Serializable {

    private static final long serialVersionUID = -915428707036605461L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_gen")
    @Column(name = "DEPARTMENT_ID")
    private Integer DEPARTMENT_ID;
    @Column(name = "DEPARTMENT_NAME")
    private String DEPARTMENT_NAME;
    @Column(name = "MANAGER_ID")
    private Integer MANAGER_ID;
    @Column(name = "LOCATION_ID")
    private Integer LOCATION_ID;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private List<Employee> employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    private Employee Manger;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private List<Job_History> Histories;
}
