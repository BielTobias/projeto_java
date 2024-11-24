package com.bd.sitebd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.sitebd.model.Computador;
import com.bd.sitebd.model.ComputadorService;
import com.bd.sitebd.model.Tool;

@Controller //mapear e processar as requisições HTTP e retornar respostas apropriadas.
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") //mapeia a URL "/" e retorna a página principal.
    public String Principal(){
        return "principal"; 
    }

    @GetMapping("/atualizar/{id}") //pega o computador específico (com base no id) e o envia para o formulário de atualização.
    public String atualizar(Model model, @PathVariable int id){
        ComputadorService cs = context.getBean(ComputadorService.class);
        Computador comp = cs.obterComputador(id);
        model.addAttribute("id", id);
        model.addAttribute("computador", comp);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}") // atualiza o computador no banco de dados com as novas informações.
    public String atualizar(@PathVariable int id, @ModelAttribute Computador comp){
        ComputadorService cs = context.getBean(ComputadorService.class);
        cs.atualizarComputador(id, comp);
        return "redirect:/listagem";
    }

    @GetMapping("/cadastro") // é chamado quando o usuário clica no link "Cadastrar Computador"
    public String cadastro(Model model){
        model.addAttribute("computador", new Computador("",""));
        return "cadastro";
    }

    @PostMapping("/cadastro") //pega as informações do formulário e salva o novo computador no banco de dados
    public String cadastrar(Model model, @ModelAttribute Computador comp){
        ComputadorService cs = context.getBean(ComputadorService.class);
        cs.inserir(comp);
        return "sucesso";
    }

    @GetMapping("/listagem") //pega todos os computadores do banco de dados e os envia para a página de listagem.
    public String listagem(Model model){
        ComputadorService cs = context.getBean(ComputadorService.class);
        List<Map<String,Object>> lista = cs.obterTodosComputadores();
        List<Computador> listaComputadores = new ArrayList<Computador>();
        for(Map<String,Object> registro : lista){
            listaComputadores.add(Tool.converterComputador(registro));
        }
        model.addAttribute("computador", listaComputadores);
        return "listagem";
    }

    @PostMapping("/deletar/{id}") // apaga o computador específico do banco de dados e, redireciona o usuário de volta para a lista.
    public String deletar(@PathVariable int id){
        ComputadorService cs = context.getBean(ComputadorService.class);
        cs.deletarComputador(id);
        return "redirect:/listagem";
    }
}