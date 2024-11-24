package com.bd.sitebd.model;

import java.util.Map;

public class Tool {
    //O objetivo desse método é converter dados armazenados em um mapa (geralmente provenientes de uma consulta ao 
    //BD, como o que seria retornado pelo jdbc.queryForMap) em um objeto Computador bem estruturado, 
    //para que o programa possa trabalhar com esses dados de forma mais prática.

    public static Computador converterComputador(Map<String,Object> registro){
        //Como registro.get retorna Object, devemos usar o polimorfismo
        //de subtipos (downcast) para recuperar os tipos originais.
        return new Computador((Integer)registro.get("id")
                             ,(String)registro.get("modelo")
                             ,(String)registro.get("defeito"));    
    }
}   
    