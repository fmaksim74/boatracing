/**
 * 
 */
package org.mif.br.model;

import javax.persistence.*;

/**
 * @author Max
 *
 */
@Entity
public class Boat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String name;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    public Division division;

}
