package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadorService {
    //O ComputadorService age como uma camada intermediária entre o controlador (a parte que lida com as requisições HTTP) e o ComputadorDAO (a parte que lida diretamente com o banco de dados). A principal função do ComputadorService é encapsular a lógica de negócios e permitir que os controladores interajam com o banco de dados de uma forma mais simples e organizada, sem se preocupar com a implementação detalhada do acesso ao banco de dados.

    //Quando o controlador precisa acessar os dados do banco, ele chama os métodos do ComputadorService (como inserir, atualizar, obter, etc.).
    //O ComputadorService então delega a ação para o ComputadorDAO, que faz a consulta ao banco de dados usando JDBC.
    //Assim, o ComputadorService separa as responsabilidades de manipulação de dados e de lógica de negócios, tornando o 
    //código maismodular e fácil de manter.               
    
    @Autowired
    ComputadorDAO cdao; //o ComputadorDAO é responsável por interagir diretamente com o BD.

    public void inserir(Computador comp){ //recebe um objeto Computador e chama o método inserir do 
        cdao.inserir(comp);               //ComputadorDAO para salvar esse computador no banco de dados.
    }

    public List<Map<String,Object>> obterTodosComputadores(){ //retorna uma lista com todos os computadores.
        return cdao.obterTodosComputadores();
    }

    public void atualizarComputador(int id, Computador comp){ //recebe um ID de computador e um objeto Computador
        cdao.atualizarComputador(id, comp);                   //chama o método atualizarComputador do ComputadorDAO para atualizar os 
    }                                                         //dados desse computador no banco de dados.

    public Computador obterComputador(int id){ //recebe um ID de computador e chama o obterComputador do ComputadorDAO para recuperar 
        return cdao.obterComputador(id);       //um computador específico com esse ID.
    }

    public void deletarComputador(int id){ //recebe um ID de computador e chama o método deletarComputador do ComputadorDAO para 
        cdao.deletarComputador(id);        //deletar esse computador do banco de dados.
    }
}
