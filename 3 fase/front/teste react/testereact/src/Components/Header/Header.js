import Logo from '../Logo/Logo';
import './Header.css';

const Header = () => {

    return(
        <div className='head-container'> 
            <Logo />
            <div> Data</div>
            <div> Icones</div>
        </div>
    );
}

export default Header;