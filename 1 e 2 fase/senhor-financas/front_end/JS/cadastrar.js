const form = document.querySelector('#formulario');

async function cadastrarUsuario() {
    let options = {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: JSON.stringify({
            id: 0,
            nome: document.querySelector('#nome').value,
            email: document.querySelector('#email').value,
            login: document.querySelector('#login').value,
            cpf: document.querySelector('#cpf').value,
            datanascimento: document.querySelector('#data-nascimento').value,
            senha: document.querySelector('#senha').value
        })
    };

    const resultado = await fetch('http://localhost:8090/senhor-financas/rest/usuario/cadastrar', options);
    const usuario = await resultado.json();

    if (usuario.idUsuario != 0) {
        alert("Cadastro realizado com sucesso.");
        window.location.href = "/front_end/index.html";
    } else {
        alert("Houve um problema no cadastro do usuário!");
    }

    form.reset();
}