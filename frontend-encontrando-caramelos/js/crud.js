const url = 'http://localhost:8080/pets'
let pets;

function ApagarRegistro(id){
    console.log(id);
    let _confirm_ = confirm("Deseja excluir este registro?")

    if(_confirm_) {
        $.ajax({
            type: 'DELETE',
            url: url + "/" + id,
            success: function(result) {},
            contentType: "application/json",
            dataType: "json",
        });
        location.reload();
    }
    alert("registro excluido com sucesso!")
}

function EditarRegistro(posicao){
    for(let i = 0; i < pets.length; i++){
        if(posicao == pets[i].id){
            $("#hdID").val(i)
            $("#modalRegistro").modal("show")
            $("#txtnome").val(pets[i].nome)
            $("#txtidade").val(pets[i].idade)
            $("#txtsexo").val(pets[i].sexo)
            $("#txtraca").val(pets[i].raca)
            $("#txtcor").val(pets[i].cor)
            $("#txtespecie").val(pets[i].especie.especie)
            $('#gridCheck1').prop('checked', pets[i].vacinado)
            $('#gridCheck2').prop('checked', pets[i].vermifugado)
            $('#gridCheck3').prop('checked', pets[i].castrado)
        }
    }

}

$(function () {
    $.getJSON(url, function(data) {
        pets = data;
        pets.forEach(item => {
            $("#tblDados tbody").append(`<tr>
            <td>${item.id}</td>
            <td>${item.nome}</td>
            <td>${item.idade}</td>
            <td>${item.sexo}</td>
            <td>${item.raca}</td>
            <td>${item.cor}</td>
            <td>${item.especie.especie}</td>
            <td>${item.vacinado}</td>
            <td>${item.vermifugado}</td>
            <td>${item.castrado}</td>
            <td><button type="button" class="btn btn-primary" onclick="javascript:EditarRegistro(${item.id});">Editar</button></td>
            <td><button type="button" class="btn btn-danger" onclick="javascript:ApagarRegistro(${item.id});">Excluir</button></td>
            </tr>`)
    
           });
           $("#tblDados").append();
    });

    $("#btnSalvar").click(function(){
        let registro = {}
        let _id = $("#hdID").val()
        let Nome = $("#txtnome").val()
        let Idade = $("#txtidade").val()
        let Sexo = $("#txtsexo").val()
        let Raca = $("#txtraca").val()
        let Cor = $("#txtcor").val()
        let Especie = $("#txtespecie").val()
        let Vacinado = $('#gridCheck1').is(":checked")
        let Vermifugado = $('#gridCheck2').is(":checked")
        let Castrado = $('#gridCheck3').is(":checked")

        registro.Nome = Nome
        registro.Idade = Idade
        registro.Sexo = Sexo
        registro.Raca = Raca
        registro.Cor = Cor
        registro.Especie = verificarEspecie(Especie)
        registro.Vacinado = Vacinado
        registro.Vermifugado = Vermifugado
        registro.Castrado = Castrado

        if(_id || _id == "0"){
            let _confirm_ = confirm("Deseja salvar registro alterado?")
    
                if(_confirm_) {
                    const body = `{"nome": "${registro.Nome}", 
                                   "idade": "${registro.Idade}",  
                                   "sexo": "${registro.Sexo}",
                                   "raca": "${registro.Raca}",
                                   "cor": "${registro.Cor}",
                                   "vacinado": "${registro.Vacinado}",
                                   "vermifugado": "${registro.Vermifugado}",
                                    "castrado": "${registro.Castrado}" }`;
                    $.ajax({
                        type: 'PUT',
                        url: url + "/" + pets[_id].id,
                        data: body,
                        success: function (result){},
                        contentType: "application/json",
                        dataType: "json"
                });
                    location.reload();
                }
            }
        else {
            let _confirm_ = confirm("Deseja salvar um novo registro?")
                if(_confirm_) {
                    const body = `{"nome": "${registro.Nome}", 
                                   "idade": "${registro.Idade}",  
                                   "sexo": "${registro.Sexo}",
                                   "raca": "${registro.Raca}",
                                   "cor": "${registro.Cor}",
                                   "vacinado": "${registro.Vacinado}",
                                   "vermifugado": "${registro.Vermifugado}",
                                    "castrado": "${registro.Castrado}",
                                    "ong": {
                                        "id": 1,
                                        "nome": "Animalar",
                                        "cnpj": "81538584000155",
                                        "telefone": "00000",
                                        "site": "www.ClubedosViralatasNovo.org.br",
                                        "entrega": true,
                                        "usuario": {
                                            "id": 1,
                                            "email": "nthumim0@stumbleupon.com",
                                            "senha": "34cPr3XwOdZ"
                                        },
                                        "responsavelOng": {
                                            "id": 1,
                                            "nome": "Franny Dominico",
                                            "cpf": "37161630665"
                                        },
                                        "tipoAjuda": {
                                            "id": 1,
                                            "tipoAjuda": "voluntaria"
                                        }
                                    },
                                    "especie": ${registro.Especie}}`;
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: body,
                        success: function(result) {},
                        contentType: "application/json",
                        dataType: "json"
            });
                location.reload();
            }
        }


        alert("registro salvo com sucesso!")
        $("#modalRegistro").modal("hide")

        //Limpa Modal
        $("#txtnome").val("")
        $("#txtidade").val("")
        $("#txtsexo").val("")
        $("#txtraca").val("")
        $("#txtcor").val("")
        $('#gridCheck1').prop("checked", false)
        $('#gridCheck2').prop("checked", false)
        $('#gridCheck3').prop("checked", false)

    })
})

function verificarEspecie(especie){
    if(especie == "Cao"){
       especie = `{
            "id": 1,
            "especie": "Cao"
        }`
    }
    else if(especie == "Gato"){
       especie = `{
            "id": 2,
            "especie": "Gato"
        }`
    } else if(especie == "Ave"){
        especie = `{
             "id": 3,
             "especie": "Aves"
         }`
     }else{
        especie = `{
            "id": 4,
            "especie": "Outros"
        }`
     }

     return especie

}