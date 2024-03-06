package com.example.cadastro

class Formulario(
    var nomeCompleto: String,
    var email: String,
    var telefone: String,
    var sexo: String,
    var vagas: String,
    var receberAtualizacao: Boolean,
    var telefoneCelular: String,
    var formacao: String,
    var tipoTelefone: String,
    var dataAniversario: String,
    var anoFormacao: String,
    var instituicao: String,
    var titulo: String,
    var orientador: String
) {
    override fun toString(): String {
        return "Formulario(nomeCompleto='$nomeCompleto', email='$email', telefone='$telefone', sexo='$sexo', vagas='$vagas', receberAtualizacao=$receberAtualizacao, telefoneCelular='$telefoneCelular', formacao='$formacao', tipoTelefone='$tipoTelefone', dataAniversario='$dataAniversario', anoFormacao='$anoFormacao', instituicao='$instituicao', titulo='$titulo', orientador='$orientador')"
    }
}