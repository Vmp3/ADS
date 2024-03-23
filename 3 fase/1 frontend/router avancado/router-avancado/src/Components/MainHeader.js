import { Link, useNavigate } from "react-router-dom";

const MainHeader = () => {
    
    const navigate = useNavigate();
    const navigateProduto = () => {
      navigate("/produtos");
    }
    const navigateHome = () => {
      navigate("/");
    }
    const navigateClientes = () => {
      navigate("/Clientes");
    }
    return (
        <div>
            <header>
                <nav>
                        <button onClick={navigateHome}>Home</button> 
                        <button onClick={navigateProduto}>Produtos</button>
                        <button onClick={navigateClientes}>Clientes</button> 
                </nav>
            </header>
        </div>
    )
}
export default MainHeader;