import { Link } from "react-router-dom";

const MainHeader = () => {
    return (
        <div>
            <header>
                <nav>
                    <ul>   
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li>
                            <Link to="/produtos">Produtos</Link>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>
    )
}
export default MainHeader;