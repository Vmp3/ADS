const form = document.querySelector('#formulario');

let despesa = {};

async function editarDespesa() {
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
        buscarDespesa();
    } else {
        alert("Houve um problema na atualização da receita!");
    }

    form.reset();
}