import Logo from '../Logo/Logo';
import './Header.css';

const Header = () => {

    function formataData(data){
        const dia = data.getDate().toString();
        return dia;
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