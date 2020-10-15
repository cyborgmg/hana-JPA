package br.com.adaApi.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MANTRA_CORPORATION database table.
 * 
 */
@Entity
@Table(name="MANTRA_CORPORATION")
@NamedQuery(name="MantraCorporation.findAll", query="SELECT m FROM MantraCorporation m")
public class MantraCorporation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CORPORATION_ID")
	private int corporationId;

	@Column(name="CERT_PASS")
	private String certPass;

	private String cnpj;

	//bi-directional many-to-one association to Mantra
	@OneToMany(mappedBy="mantraCorporation")
	private List<Mantra> mantras;

	public MantraCorporation() {
	}

	public int getCorporationId() {
		return this.corporationId;
	}

	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}

	public String getCertPass() {
		return this.certPass;
	}

	public void setCertPass(String certPass) {
		this.certPass = certPass;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Mantra> getMantras() {
		return this.mantras;
	}

	public void setMantras(List<Mantra> mantras) {
		this.mantras = mantras;
	}

	public Mantra addMantra(Mantra mantra) {
		getMantras().add(mantra);
		mantra.setMantraCorporation(this);

		return mantra;
	}

	public Mantra removeMantra(Mantra mantra) {
		getMantras().remove(mantra);
		mantra.setMantraCorporation(null);

		return mantra;
	}

}