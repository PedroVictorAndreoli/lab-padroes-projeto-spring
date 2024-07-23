package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.service.PessoaService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements PessoaService<Fornecedor> {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.get();
    }

    @Override
    public void inserir(Fornecedor cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Fornecedor cliente) {
        Optional<Fornecedor> clienteBd = fornecedorRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }

    private void salvarClienteComCep(Fornecedor cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        fornecedorRepository.save(cliente);
    }
}
