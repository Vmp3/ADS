const form = document.querySelector('#formulario');
const limpar = document.querySelector('#limpar');

let despesa = {};

async function buscarDespesas() {
    let options = {
        method: "GET",
        headers: { "Content-type": "application/json" }
    };

    const listaDespesas = await fetch('http://localhost:8080/pessoa/rest/pessoa/listar', options);

    const listaDespesasJson = await listaDespesas.json();

    if (listaDespesasJson.length != 0) {
        preencherTabela(listaDespesasJson);
    } else {
        alert("Houve um problema na busca das despesas!");
    }
}

buscarDespesas();

function preencherTabela(dados) {
    let tbody = document.getElementById('tbody');

    tbody.innerText = '';

    for (let i = 0; i < dados.length; i++) {
        let tr = tbody.insertRow();
        let td_id = tr.insertCell();
        let td_descricao = tr.insertCell();
        let td_valor = tr.insertCell();
        let td_dataVencimento = tr.insertCell();
        let td_dataPagamento = tr.insertCell();

        td_id.innerText = dados[i].id;
        td_descricao.innerText = dados[i].descricao;
        td_valor.innerText = dados[i].valor;
        td_dataVencimento.innerText = formatarData(dados[i].td_dataVencimento);
        td_dataPagamento.innerText = formatarData(dados[i].td_dataPagamento);
        

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
        excluir.setAttribute('onclick', 'excluirDespesa(' + JSON.stringify(dados[i]) + ')');
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
    despesa = {};
    form.reset();
});

async function excluirDespesa(dados) {
    let options = {
        method: "DELETE",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: dados.id,
            descricao: dados.descricao,
            valor: dados.valor,
            dataVencimento: dados.dataVencimento,
            dataPagamento: dados.dataPagamento
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/excluir', options);

    if (resultado.ok == true) {
        alert("Exclusão realizada com sucesso!");
        despesa = {};
        buscarDespesas();
    } else {
        alert("Houve um problema na exclusão da despesa!");
    }
}

form.addEventListener('submit', (evento) => {
    evento.preventDefault();
    if (despesa.id != undefined) {
        atualizarDespesa();
    } else {
        cadastrarDespesa();
    }
});

async function cadastrarDespesa() {
    let options = {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: 0,
            descricao: document.querySelector('#descricao').value,
            valor: document.querySelector('#valor').value,
            dataVencimento: document.querySelector('#data-vencimento').value,
            dataPagamento: document.querySelector('#data-pagamento').value
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/cadastrar', options);
    despesa = await resultado.json();

    if (despesa.id != 0) {
        alert("Cadastro realizado com sucesso!");
        despesa = {};
        buscarDespesas();
    } else {
        alert("Houve um problema no cadastro da despesa!");
    }

    form.reset();
}

async function atualizarDespesa() {
    let options = {
        method: "PUT",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: despesa.id,
            descricao: document.querySelector('#descricao').value,
            valor: document.querySelector('#valor').value,
            dataVencimento: document.querySelector('#data-vencimento').value,
            dataPagamento: document.querySelector('#data-pagamento').value
        })
    };

    const resultado = await fetch('http://localhost:8080/pessoa/rest/pessoa/atualizar', options);

    if (resultado.ok == true) {
        alert("Atualização realizada com sucesso!");
        despesa = {};
        buscarDespesas();
    } else {
        alert("Houve um problema na atualização da despesa!");
    }

    form.reset();
}

async function editarDespesa(dados) {
    despesa.id = dados.id;
    document.querySelector('#descricao').value = dados.descricao;
    document.querySelector('#valor').value = dados.valor;
    document.querySelector('#data-vencimento').value = dados.dataVencimento;
    document.querySelector('#data-pagamento').value = dados.dataPagamento;
}