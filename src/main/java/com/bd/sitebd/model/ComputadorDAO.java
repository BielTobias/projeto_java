package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ComputadorDAO { //DAO - Data Access Object - responsável pela interação com o BD.

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc; //classe do Spring que facilita a execução de operações no banco de dados, como consultas e atualizações.

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Computador comp){ // insere um novo computador na tabela computador do BD
        String sql = "INSERT INTO computador(modelo, defeito) VALUES (?,?);";
        Object[] parametros = new Object[2];
        parametros[0] = comp.getModelo();
        parametros[1] = comp.getDefeito();
        jdbc.update(sql,parametros);
    }

    public List<Map<String,Object>> obterTodosComputadores(){ // retorna todos os computadores da tabela computador.
        String sql = "Select * from computador;";
        return jdbc.queryForList(sql);
    }

    public void atualizarComputador(int id, Computador comp){ // atualiza os dados de um computador existente na tabela.
        String sql = "UPDATE computador SET ";
        sql += "modelo = ?, defeito = ? WHERE id = ?";
        jdbc.update(sql, comp.getModelo(), comp.getDefeito(), id);
    }

    public Computador obterComputador(int id){ //recupera um computador com base no seu id.
        String sql = "Select * from computador where id = ?";
        return Tool.converterComputador(jdbc.queryForMap(sql,id));
    }

    public void deletarComputador(int id){ // exclui um computador da tabela com base no id.
        String sql = "DELETE FROM computador where id = ?";
        jdbc.update(sql,id);
    }
}
