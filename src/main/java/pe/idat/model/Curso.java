package pe.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	//pruevas3
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="curso_profesor",joinColumns = 
				@JoinColumn(name="id_curso",
				nullable = false,unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references cursos(id_curso)") 
	
				),
				inverseJoinColumns = @JoinColumn(name="id_profesor",
				nullable = false,unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references profesores(id_profesor)") 
	
				)

	)
	private List<Profesor> profesores = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="id_malla",
				nullable = false,
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallas(id_malla)"))
	private Malla malla;
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
