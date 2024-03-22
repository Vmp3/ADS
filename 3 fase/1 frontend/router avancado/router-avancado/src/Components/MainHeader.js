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
                    <ul>  
                        <li><button onClick={navigateHome}>Home</button></li> 
                        <li><button onClick={navigateClientes}>Clientes</button></li> 
                        <li><button onClick={navigateProduto}>Produtos</button></li>
                        
                    </ul>
                </nav>
            </header>
        </div>
    )
}
export default MainHeader;