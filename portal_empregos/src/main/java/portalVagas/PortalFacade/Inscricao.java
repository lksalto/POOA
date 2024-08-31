package portalVagas.PortalFacade;

public class Inscricao {
	
	private Candidato candidato;
	private Vaga vaga;
	
	Inscricao(Vaga vaga, Candidato candidato) {
		this.vaga = vaga;
		this.candidato = candidato;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
