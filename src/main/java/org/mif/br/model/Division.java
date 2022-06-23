/**
 * 
 */
package org.mif.br.model;

import java.util.List;

import javax.persistence.*;

/**
 * @author Max
 *
 */
@Entity
public class Division {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String name;
    
    @Transient
    @OneToMany
    public List<Boat> boats;
    
}
