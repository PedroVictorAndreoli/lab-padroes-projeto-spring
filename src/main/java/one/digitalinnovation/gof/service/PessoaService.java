package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface PessoaService<T> {

	Iterable<T> buscarTodos();

	T buscarPorId(Long id);

	void inserir(T cliente);

	void atualizar(Long id, T cliente);

	void deletar(Long id);

}
