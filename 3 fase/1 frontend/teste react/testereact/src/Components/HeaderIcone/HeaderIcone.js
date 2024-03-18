import iconemedico from "./medico.svg";
import iconepaciente from "./paciente.svg";
const HeaderIcone = () =>{


    return(
        <div>
            <img src={iconemedico} alt="icone-medico"/>
            <img src={iconepaciente} alt ="icone-paciente"/>
        </div>
    );
}

export default HeaderIcone