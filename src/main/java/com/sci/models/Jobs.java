package com.sci.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Jobs", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Jobs implements Serializable{
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "JOB_ID")
    private String JOB_ID;
    @Column(name = "JOB_TITLE")
    private String JOB_TITLE;
    @Column(name = "MIN_SALARY")
    private Integer MIN_SALARY;
    @Column(name = "MAX_SALARY")
    private Integer MAX_SALARY;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private List<Employee> employees;
}
