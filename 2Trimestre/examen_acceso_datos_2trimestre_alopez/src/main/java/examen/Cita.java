package examen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "hora")
	private LocalTime hora;

	// Constructor vacío
	public Cita() {
	}

	// Constructor con todos los campos
	public Cita(Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora) {
		this.paciente = paciente;
		this.medico = medico;
		this.fecha = fecha;
		this.hora = hora;
	}

	// Constructor adicional con Long, Long, LocalDate y LocalTime
	public Cita(Long idPaciente, Long idMedico, LocalDate fecha, LocalTime hora) {
		this.id = null; 
		this.paciente = new Paciente(); 
		this.paciente.setId(idPaciente);
		this.medico = new Medico(); 
		this.medico.setId(idMedico);
		this.fecha = fecha;
		this.hora = hora;
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Cita{" + "id=" + id + ", idPaciente=" + (paciente != null ? paciente.getId() : "N/A") + ", idMedico="
				+ (medico != null ? medico.getId() : "N/A") + ", fecha=" + fecha + ", hora=" + hora + '}';
	}
}
