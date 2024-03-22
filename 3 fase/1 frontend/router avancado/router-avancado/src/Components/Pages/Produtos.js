import { Link } from "react-router-dom";
const Produtos = () => {
    return (
        <div>
            <h1> 
                Produtos 
            </h1>
            <ul>
                <li><Link to={"/produtos/p1"}>Produto 1</Link></li>
                <li><Link to={"/produtos/p2"}>Produto 2</Link></li>
                <li>Produto 3</li>
            </ul>
        </div>
    )
}

export default Produtos;