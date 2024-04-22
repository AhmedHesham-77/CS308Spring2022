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
@Table(name = "Locations", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "loc_gen", sequenceName = "locations_seq", allocationSize = 1)
public class Locations implements Serializable {

    private static final long serialVersionUID = -915428707036605461L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loc_gen")
    @Column(name = "location_id")
    private Integer location_id;
    @Column(name = "STREET_ADDRESS")
    private String STREET_ADDRESS;
    @Column(name = "POSTAL_CODE")
    private String POSTAL_CODE;
    @Column(name = "CITY")
    private String CITY;
    @Column(name = "STATE_PROVINCE")
    private String STATE_PROVINCE;
    @Column(name = "COUNTRY_ID")
    private String COUNTRY_ID;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id",insertable = false,updatable = false)
    private List<Departments> departments;
}
