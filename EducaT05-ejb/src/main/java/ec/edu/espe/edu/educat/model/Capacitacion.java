/*
 * Entidad que almacena la informacion correspondiente a la capacitacion que 
 * el instituto ofrece
 */
package ec.edu.espe.edu.educat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "capacitacion")

public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CAPACITACION", nullable = false)
    /*
    * Llave primaria que corresponde al codigo de la capacitacion
     */
    private Integer codCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    /*
    * Atributo que almacena la fecha de inicio de una capacitacion
     */
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    /*
    * Atributo que almacena la fecha de finalizacion de la capacitacion
     */
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO", nullable = false, length = 3)
    /*
    * Atributo que almacena el estado de la capacitacion estos estados pueden 
    * ser: Inscripciones, En Progreso, Finalizada, Cancelada, Definida : 
    * (INS-PRO-FIN-CAN-DEF)
     */
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD", nullable = false)
    /*
    * Atributo que almacena la capacidad que puede tener una capactiacion
     */
    private short capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<CapacitacionAlumno> capacitacionAlumnoList;
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO",
            nullable = false)
    @ManyToOne(optional = false)
    /*
    * Llave foránea que corresponde al codigo del curso 
     */
    private Curso codCurso;
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_DOCENTE")
    @ManyToOne
    /*
    * Clave primaria que corresponde a la cédula de identidad del docente
     */
    private Docente codDocente;

    public Capacitacion() {
    }

    public Capacitacion(Integer codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public Capacitacion(Integer codCapacitacion, Date fechaInicio,
            Date fechaFin, String estado, short capacidad) {
        this.codCapacitacion = codCapacitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public Integer getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(Integer codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public List<CapacitacionAlumno> getCapacitacionAlumnoList() {
        return capacitacionAlumnoList;
    }

    public void setCapacitacionAlumnoList(List<CapacitacionAlumno> capacitacionAlumnoList) {
        this.capacitacionAlumnoList = capacitacionAlumnoList;
    }

    public Curso getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Curso codCurso) {
        this.codCurso = codCurso;
    }

    public Docente getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Docente codDocente) {
        this.codDocente = codDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCapacitacion != null ? codCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.codCapacitacion == null && other.codCapacitacion != null) || (this.codCapacitacion != null && !this.codCapacitacion.equals(other.codCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.edu.educat.model.Capacitacion[ codCapacitacion=" + codCapacitacion + " ]";
    }

}
