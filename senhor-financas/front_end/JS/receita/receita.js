const form = document.querySelector('#formulario');
const limpar = document.querySelector('#limpar');

let usuarioLogado = sessionStorage.getItem('usuario');
usuarioLogado = JSON.parse(usuarioLogado);

let receita = {};

async function buscarReceitas() {
    console.log(usuarioLogado)
    let id = usuarioLogado.id;
    let options = {
        method: "GET",
        headers: { "Content-type": "application/json" }
    };

    const listaReceitas = await fetch('http://localhost:8090/senhor-financas/rest/receita/listar/' + id, options);

    const listaReceitasJson = await listaReceitas.json();

    if (listaReceitasJson.length != 0) {
        preencherTabela(listaReceitasJson);
    } else {
        alert("Houve um problema na busca das receitas!");
    }
}

buscarReceitas();

function preencherTabela(dados) {
    let tbody = document.getElementById('tbody');

    tbody.innerText = '';

    for (let i = 0; i < dados.length; i++) {
        let tr = tbody.insertRow();
        let td_id = tr.insertCell();
        let td_descricao = tr.insertCell();
        let td_dataReceita = tr.insertCell();
        let td_valor = tr.insertCell();

        td_id.innerText = dados[i].id;
        td_descricao.innerText = dados[i].descricao;
        td_dataReceita.innerText = formatarData(dados[i].dataReceita);
        td_valor.innerText = dados[i].valor;
        

        // Cria botões de editar e excluir
        let editar = document.createElement('button');
        editar.textContent = 'Editar';
        editar.style.height = '30px';
        editar.style.width = '100px';
        editar.style.margin = '5px';
        editar.style.padding = '2px';
        editar.setAttribute('onclick', 'editarReceita(' + JSON.stringify(dados[i]) + ')');
        td_acoes.appendChild(editar);

        let excluir = document.createElement('button');
        excluir.textContent = 'Excluir';
        excluir.style.height = '30px';
        excluir.style.width = '100px';
        excluir.style.margin = '5px';
        excluir.style.padding = '2px';
        excluir.setAttribute('onclick', 'excluirReceita(' + JSON.stringify(dados[i]) + ')');
        td_acoes.appendChild(excluir);
    }
}

function formatarData(data) {
    let dataFormatada = new Date(data),
        dia = dataFormatada.getDate().toString().padStart(2, '0'),
        mes = (dataFormatada.getMonth() + 1).toString().padStart(2, '0'),
        ano = dataFormatada.getFullYear();
    return dia + "/" + mes + "/" + ano;
}

limpar.addEventListener('click', (evento) => {
    evento.preventDefault();
    receita = {};
    form.reset();
});

async function excluirReceita(dados) {
    let options = {
        method: "DELETE",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: dados.id,
            descricao: dados.descricao,
            dataReceita: dados.dataReceita,
            valor: dados.valor
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/excluir', options);

    if (resultado.ok == true) {
        alert("Exclusão realizada com sucesso!");
        receita = {};
        buscarReceitas();
    } else {
        alert("Houve um problema na exclusão da receita!");
    }
}

form.addEventListener('submit', (evento) => {
    evento.preventDefault();
    if (receita.id != undefined) {
        atualizarReceita();
    } else {
        cadastrarReceita();
    }
});

async function cadastrarReceita() {
    let options = {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: 0,
            descricao: document.querySelector('#descricao').value,
            dataReceita: document.querySelector('#data-receita').value,
            valor: document.querySelector('#valor').value
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/cadastrar', options);
    receita = await resultado.json();

    if (receita.id != 0) {
        alert("Cadastro realizado com sucesso!");
        receita = {};
        buscarReceitas();
    } else {
        alert("Houve um problema no cadastro da receita!");
    }

    form.reset();
}

async function atualizarReceita() {
    let options = {
        method: "PUT",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: receita.id,
            descricao: document.querySelector('#descricao').value,
            dataReceita: document.querySelector('#data-receita').value,
            valor: document.querySelector('#valor').value
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/atualizar', options);

    if (resultado.ok == true) {
        alert("Atualização realizada com sucesso!");
        receita = {};
        buscarReceitas();
    } else {
        alert("Houve um problema na atualização da receita!");
    }

    form.reset();
}

async function editarReceita(dados) {
    receita.id = dados.id;
    document.querySelector('#descricao').value = dados.descricao;
    document.querySelector('#data-receita').value = dados.dataReceita;
    document.querySelector('#valor').value = dados.valor;
}