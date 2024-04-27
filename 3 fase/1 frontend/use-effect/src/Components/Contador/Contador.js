import { Fragment,useEffect, useState } from "react";

const Contador = () => {

    const [cont, setCont] = useState(0);

    useEffect(() =>{

        document.title = `Contador: ${cont}`;
    }, [cont]);


    return(
        <Fragment>
            <button onClick={() => setCont(cont + 1)}> Contar</button>
        </Fragment>
    )
}

export default Contador;