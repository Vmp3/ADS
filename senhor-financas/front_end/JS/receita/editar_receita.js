const form = document.querySelector('#formulario');

let receita = {};

async function editarReceita() {
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
        buscarReceita();
    } else {
        alert("Houve um problema na atualização da receita!");
    }

    form.reset();
}