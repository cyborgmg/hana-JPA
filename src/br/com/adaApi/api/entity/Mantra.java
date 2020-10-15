package br.com.adaApi.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MANTRA database table.
 * 
 */
@Entity
@NamedQuery(name="Mantra.findAll", query="SELECT m FROM Mantra m")
public class Mantra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_CE_MERCANTE")
	private String numeroCeMercante;

	@Column(name="CERT_PASS")
	private String certPass;

	@Column(name="DATA_PRESENCA")
	private String dataPresenca;

	//bi-directional many-to-one association to MantraCorporation
	@ManyToOne
	@JoinColumn(name="CORPORATION_ID")
	private MantraCorporation mantraCorporation;

	public Mantra() {
	}

	public String getNumeroCeMercante() {
		return this.numeroCeMercante;
	}

	public void setNumeroCeMercante(String numeroCeMercante) {
		this.numeroCeMercante = numeroCeMercante;
	}

	public String getCertPass() {
		return this.certPass;
	}

	public void setCertPass(String certPass) {
		this.certPass = certPass;
	}

	public String getDataPresenca() {
		return this.dataPresenca;
	}

	public void setDataPresenca(String dataPresenca) {
		this.dataPresenca = dataPresenca;
	}

	public MantraCorporation getMantraCorporation() {
		return this.mantraCorporation;
	}

	public void setMantraCorporation(MantraCorporation mantraCorporation) {
		this.mantraCorporation = mantraCorporation;
	}

}