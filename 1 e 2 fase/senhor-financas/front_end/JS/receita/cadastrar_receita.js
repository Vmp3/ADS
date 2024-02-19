const form = document.querySelector('#formulario');

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
    const receita = await resultado.json();

    if (receita.id != 0) {
        alert("Cadastro realizado com sucesso!");
        receita = {};
        buscarReceita();
    } else {
        alert("Houve um problema no cadastro da receita!");
    }

    form.reset();
}