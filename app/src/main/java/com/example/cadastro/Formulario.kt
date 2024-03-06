package com.example.cadastro

class Formulario(
    var nomeCompleto: String,
    var email: String,
    var telefone: String,
    var cidade: String,
    var uf: String?,
    var sexo: String,
    var vaiIngressar: Boolean
) {
    override fun toString(): String {
        return "Formulário: \n" +
                "Nome completo: $nomeCompleto\n" +
                "Email: $email\n" +
                "Telefone: $telefone\n" +
                "Cidade: $cidade\n" +
                "UF: $uf\n" +
                "Sexo: $sexo\n" +
                "Vai ingressar: $vaiIngressar"
    }
}