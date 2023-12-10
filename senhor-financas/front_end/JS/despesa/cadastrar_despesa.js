const form = document.querySelector('#formulario');

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
    const despesa = await resultado.json();

    if (despesa.id != 0) {
        alert("Cadastro realizado com sucesso!");
        despesa = {};
        buscarDespesa();
    } else {
        alert("Houve um problema no cadastro da Despesa!");
    }

    form.reset();
}