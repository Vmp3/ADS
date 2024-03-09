import Logo from '../Logo/Logo';
import HeaderIcone from '../HeaderIcone/HeaderIcone';
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
            <div>{formataData(new Date)} </div>
            <HeaderIcone/> 
        </div>
    );
}

export default Header;