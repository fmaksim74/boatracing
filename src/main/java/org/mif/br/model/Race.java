/**
 * 
 */
package org.mif.br.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * @author Max
 *
 */
@Entity
public class Race {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String name;
    public Date eventDate;
    
    @OneToMany
    public List<Boat> racers;
}
