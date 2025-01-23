package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {

	public void create(Pessoa pessoa) {

		var connection = ConnectionFactory.getConnection();

		try {
			var query = "INSERT INTO pessoa(nome,email) values (?,?)";

			var statement = connection.prepareStatement(query);

			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			statement.execute();
			var result = statement.executeUpdate();

			if (result ==1) {
				System.out.println("\nPESSOA CADASTRADA COM SUCESSO!");
			} else {
				System.out.println("\nNENHUM REGISTRO FOI ADICIONADO O BANCO DE DADOS.");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PESSOA:");
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Pessoa pessoa) {

		var connection = ConnectionFactory.getConnection();

		try {

			var query = "UPDATE pessoa SET nome=?, email=?, where id=?";

			var statement = connection.prepareStatement(query);
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			statement.setInt(3, pessoa.getId());
			var result = statement.executeUpdate();
			if (result ==1) {
				System.out.println("\nPESSOA ATUALIZADO COM SUCESSO!");
			}

			else {
				System.out.println("\nNENHUM REGISTRO FOI ATUALIZADO NO BANCO DE DADOS. VERIFIQUE O ID INFORMADO.");
			}
		}

		catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR PESSOA:");
			System.out.println(e.getMessage());
		}

		finally {

			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete (Integer id) {

		var connection = ConnectionFactory.getConnection();

		try {

			var query = "DELETE from pessoa where id=?";

			var statement = connection.prepareStatement(query);
             statement.setInt(1,id);
			var result = statement.executeUpdate();
			if (result ==1) {
				System.out.println("\nPESSOA EXCLUIDA COM SUCESSO!");
			}

			else {
				System.out.println("\nNENHUM REGISTRO FOI EXCLUIDO NO BANCO DE DADOS. VERIFIQUE O ID INFORMADO.");
			}
		}

		catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIR PESSOA:");
			System.out.println(e.getMessage());
		}

		finally {

			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


public List<Pessoa> findAll() {
  
    var connection = ConnectionFactory.getConnection();
   
    try {           
                     var query = "SELECT * FROM pessoa ORDER BY id";
                     var statement = connection.prepareStatement(query);
                     var result = statement.executeQuery();          
                     var lista = new ArrayList<Pessoa>(); 
                    
            while(result.next()) {
                    var pessoa = new Pessoa();                   
                    pessoa.setId(result.getInt("id")); //ler o id da pessoa
                    pessoa.setNome(result.getString("nome")); //ler o nome da pessoa
                    pessoa.setEmail(result.getString("email")); //ler o email da pessoa
                 
                    lista.add(pessoa);
            }
            
            return lista;
    }
    catch(Exception e) {
            System.out.println("\nFALHA AO CONSULTAR PESSOAS:");
            System.out.println(e.getMessage());
            return null;
    }
    finally {
            try {
                    connection.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
            }
}
}