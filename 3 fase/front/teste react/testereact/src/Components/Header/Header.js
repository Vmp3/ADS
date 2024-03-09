import Logo from '../Logo/Logo';
import './Header.css';

const Header = () => {

    return(
        <div className='head-container'> 
            <Logo />
            <div> {new Date().getMonth()}</div>
            <div> Icones</div>
        </div>
    );
}

export default Header;