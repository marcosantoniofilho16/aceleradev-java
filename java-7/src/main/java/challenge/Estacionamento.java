package challenge;

import java.util.LinkedList;
import java.util.Queue;

public class Estacionamento {
	
	Queue<Carro> estacionamento = new LinkedList<Carro>();
	
	private void validarEstacionamento(Carro carro) {
		if (carro.getMotorista() == null)
			throw new EstacionamentoException("n�o � permitido veiculo autonomo");
		
		if (carro.getMotorista().getIdade() < 18)
			throw new EstacionamentoException("n�o � permitido de menor");
		
		if (carro.getMotorista().getPontos() > 20)
			throw new EstacionamentoException("n�o � permitido motorista sem pontos");
	}

    public void estacionar(Carro carro) {
    	validarEstacionamento(carro);
    	
    	if (carrosEstacionados() < 10)
    		estacionamento.add(carro);
    	else {
    		for (Carro carroEstacionado : estacionamento)
				if (carroEstacionado.getMotorista().getIdade() < 55) {
					estacionamento.remove(carroEstacionado);
					break;
				}
    		
    		if (carrosEstacionados() < 10)
    			estacionamento.add(carro);
    		else
    			throw new EstacionamentoException("n�o h� vagas");
    			
    	}
    }

    public int carrosEstacionados() {
        return estacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estacionamento.contains(carro);
    }
}
