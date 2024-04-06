import Logo from '../Logo/Logo';
import './Header.css';
import HeaderSocial from '../HeaderSocial/HeaderSocial';
import Navegation from '../Navegation/Navegation';
const Header = () => {

    return (
        <div className="head-container">
            <Logo/>
            <HeaderSocial/>
            <Navegation/>
        </div>
    
)
}

export default Header;