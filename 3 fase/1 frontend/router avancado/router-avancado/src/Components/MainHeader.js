import { Link, useNavigate } from "react-router-dom";

const MainHeader = () => {
    
    const navigate = useNavigate();
    const navigateClick = () => {
      navigate("/produtos");
    }
    return (
        <div>
            <header>
                <nav>
                    <ul>   
                        <li><Link to="/">Home</Link></li>
                        <li><Link to="/produtos">Produtos</Link></li>
                        <li><Link to="/clientes">Clientes</Link></li>
                        <li><button onClick={navigateClick}>Produtos</button></li>
                    </ul>
                </nav>
            </header>
        </div>
    )
}
export default MainHeader;