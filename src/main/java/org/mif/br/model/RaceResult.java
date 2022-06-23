/**
 * 
 */
package org.mif.br.model;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Max
 *
 */
@Entity
public class RaceResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    
    @OneToOne
    public Race race;
    
    @OneToOne
    public Boat boat;
    
    public Date start;
    public Date finish;
    public Long duration;
    
    public Short position;
    
}
