import { Fragment } from "react";
import MainHeader from "../MainHeader";

const Erro404 = () => {
    return (
        <Fragment>
            <MainHeader />
            <h1>Ops! Algo deu errado</h1>
            <p> Erro - Codigo 404 - Pagina nao encontrada</p>
        </Fragment>
    );
};

export default Erro404;