import { Link } from "react-router-dom";
const Produtos = () => {
    const PRODUTOS = [
        { id: "01", title: "Mouse" },
        { id: "02", title: "Teclado" },
        { id: "03", title: "Memória" },
        { id: "04", title: "Monitor" },
    ];

    return (
        <div>
            <h1>Lista de Produtos</h1>
            <ul>
                {PRODUTOS.map((prod) => (
                    <li>
                        <Link to={`/produtos/${prod.id}`}>{prod.title}</Link>
                    </li>
                ))}

                {/*<li><Link to={"/produtos/p1"}>Produto 1</Link></li>
                <li><Link to={"/produtos/p2"}>Produto 2</Link></li>
                <li><Link to={"/produtos/p3"}>Produto 3</Link></li>
                <li><Link to={"/produtos/mouse"}>mouse</Link></li>*/}
            </ul>
        </div>
    );
};

export default Produtos;
