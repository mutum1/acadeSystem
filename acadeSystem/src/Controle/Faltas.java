package Controle;
// Generated 28/06/2015 16:31:30 by Hibernate Tools 3.6.0



/**
 * Faltas generated by hbm2java
 */
public class Faltas  implements java.io.Serializable {


     private int id;
     private Float faltas;

    public Faltas() {
    }

	
    public Faltas(int id) {
        this.id = id;
    }
    public Faltas(int id, Float faltas) {
       this.id = id;
       this.faltas = faltas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Float getFaltas() {
        return this.faltas;
    }
    
    public void setFaltas(Float faltas) {
        this.faltas = faltas;
    }




}


