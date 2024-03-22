import { useParams } from "react-router-dom";

const DetalharProduto = () => {
    const params = useParams();

    return (
            <>
                <h1>Detalhe do produto</h1>
                <p>{params.produtoId}</p>
            </>
        );
}
export default DetalharProduto;