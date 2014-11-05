import java.util.Date;
import java.util.List;

import br.com.projeto.beans.Paciente;
import br.com.projeto.conexao.ConnectionFactory;

public class incluirPaciente {

	public static void main(String[] args) {
		Paciente p = new Paciente();
		p.setId(2);
		p.setNome("Marcelo");
		p.setRg("Teste");
		p.setSexo("Masculino");
		p.setTelefone("9916-9630");
		p.setData_nascimento(new Date());
		p.setEndereco("Endereco Teste");
		
		try {
            ConnectionFactory.getInstance().getPacienteDAO().inserir(p);
            System.out.println("Paciente Incluido Com Sucesso!!!");
			for(Paciente paciente : ConnectionFactory.getInstance().getPacienteDAO().consultar()){
				System.out.println("");
				System.out.println("Paciente Id:"+paciente.getId());
				System.out.println("Paciente Nome:"+paciente.getNome());
				System.out.println("Paciente Sexo:"+paciente.getSexo());
				System.out.println("Paciente Rg:"+paciente.getRg());
				System.out.println("Paciente Endereco:"+paciente.getEndereco());
				System.out.println("Paciente Data Nascimento:"+paciente.getData_nascimento());
				System.out.println("Paciente Telefone:"+paciente.getTelefone());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}

}
