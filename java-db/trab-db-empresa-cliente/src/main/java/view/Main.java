package view;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

import DAO.*;
import model.*;


public class Main {
    public static void main(String[] args) {
        Cidade cidade = new Cidade("cidade1", 11, 10);
        Cidade cidade1 = new Cidade("cidade2", 12, 10);
        CidadeDAO cid = new CidadeDAO();

        Endereco endereco = new Endereco("rua edgar", "siles", "1311", "61621200", 1);
        Endereco endereco1 = new Endereco("rua coronel furtado", "montese", "2341", "663321400", 1);
        EnderecoDAO end = new EnderecoDAO();

        Empresa empresa = new Empresa("cagece", "1445823301", "bom dia e bom trabalho", 4);
        Empresa empresa1 = new Empresa("enel", "4231321321", "como dizia: faça o que der", 4);
        EmpresaDAO emp = new EmpresaDAO();

        Cliente cliente = new Cliente("carlos", new Date(10), "454335550", "jpppp@gmail.com", 4);
        Cliente cliente1 = new Cliente("pedro", new Date(10), "134438444", "lessssgo@gmail.com", 4);
        ClienteDAO c = new ClienteDAO();

        OrdemServico os = new OrdemServico("carregar o front", Timestamp.from(Instant.now()), null, "jppn321", 1, 2);
        OrdemServico os1 = new OrdemServico("testar o back", Timestamp.from(Instant.now()), null, "jppn123", 1, 2);
        OrdemServicoDAO o = new OrdemServicoDAO();

        ItemOrdemServico i = new ItemOrdemServico("arrumar o crash", 5.91, 1);
        ItemOrdemServico i1 = new ItemOrdemServico("continuar a regra de negocio", 10.34, 1);
        ItemOrdemServicoDAO io = new ItemOrdemServicoDAO();


        cid.insertCidade(cidade);
        System.out.println(cid.selectAllCidade());
        cid.updateCidade(cidade1, 1);
        System.out.println(cid.selectCidade(1).getDescricao());
//        cid.deleteCidade(2);


        end.insertEndereco(endereco);
        System.out.println(end.selectAllEndereco());
        end.updateEndereco(endereco1, 4);
        System.out.println(end.selectEndereco(4).getRua());
//        end.deleteEndereco(7);


        c.insertCliente(cliente);
        System.out.println(c.selectAllCliente());
        c.updateCliente(cliente1, 2);
        System.out.println(c.selectCliente(2).getNome());
//        c.deleteCliente(4);


        emp.insertEmpresa(empresa);
        System.out.println(emp.selectAllEmpresa());
        emp.updateEmpresa(empresa1, 5);
        System.out.println(emp.selectEmpresa(5).getNome());
//        emp.deleteEmpresa(6);


        o.insertOrdemServico(os);
        System.out.println(o.selectAllOrdemServico());
        o.updateOrdemServico(os1, 1);
        System.out.println(o.selectOrdemServico(1).getObservacao());
//        o.deleteOrdemServico(3);


        io.insertItemOrdemServico(i);
        System.out.println(io.selectAllItemOrdemServico());
        io.updateItemOrdemServico(i1, 1);
        System.out.println(io.selectItemOrdemServico(1).getDescricao());
//        io.deleteItemOrdemServico(3);

    }
}
