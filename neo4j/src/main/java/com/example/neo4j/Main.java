package com.example.neo4j;

import org.neo4j.driver.*;

import java.time.LocalDate;

import static org.neo4j.driver.Values.parameters;

public class Main {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "testeneo4j"));

        Pessoa pessoa = new Pessoa("123.456.789-10", "Jefferson",
                LocalDate.of(2000, 12, 12));

        Pessoa pessoa2 = new Pessoa("012.345.678-90", "Maomé",
                LocalDate.of(1999, 10, 14));

        try (Session session = driver.session()) {
            // Adicionando uma pessoa
            /*
            session.run("CREATE (p:Pessoa{cpf: $cpf, nome: $nome, nascimento: $nascimento})",
                    parameters("cpf", pessoa2.getCpf(), "nome", pessoa2.getNome(),
                            "nascimento", pessoa2.getNascimento()));
            */

            // Criar um relacionamento
            /*
            session.run("MATCH (p1:Pessoa{cpf: $cpf}), (p2:Pessoa{cpf: $cpf2})" +
                    "CREATE (p1)-[:AMIGO]->(p2)",
                    parameters("cpf", "123.456.789-10", "cpf2", "012.345.678-90"));
             */

            // Consultar pessoa
            /*
            Result result = session.run("MATCH (p:Pessoa{cpf:$cpf}) RETURN p",
                    parameters("cpf", "123.456.789-10"));

            result.list().forEach(r -> System.out.println(r.get(0).asNode().values()));
             */

        } finally {
            driver.close();
        }
    }
}
