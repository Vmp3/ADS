import { Link } from "react-router-dom";
const Home = () =>{

        return(
            <div>
                <h1>PAGINA INICIAL </h1>
                <h1>aula de react</h1>
                <Link to={"/"}>Home</Link>
                <Link to={"/produtos"}>Produto</Link>
            </div>
        );
}
export default Home