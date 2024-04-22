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
@Table(name = "Regions", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor

public class Regions implements Serializable{
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "Region_ID")
    private Integer Region_Id;
    @Column(name = "Region_Name")
    private String Region_Name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id",insertable = false,updatable = false)
    private List<COUNTRIES> countries;
}
