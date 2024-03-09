import Logo from '../Logo/Logo';
import './Header.css';

const Header = () => {

    function formataData(data){
        const dia = data.getDate().toString().padStart(2,'0');
        const mes = (data.getMonth()+ 1).toString().padStart(2,'0');
        const ano = (data.getFullYear()).toString();
        const hora = data.getHours().toString().padStart(2,'0');
        const minuto = data.getMinutes().toString().padStart(2,'0');
        return `${dia}/${mes}/${ano} ${hora}:${minuto}`;
    }
    return(
        <div className='head-container'> 
            <Logo />
            <div> Data: {formataData(new Date)} </div>
            <div> Icones </div>
        </div>
    );
}

export default Header;