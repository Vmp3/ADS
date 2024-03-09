import logomarca from './logo.svg';
import './Logo.css';
const Logo = () => {

    return(
        <div>
            <img src={logomarca} alt="logo-marca" />
            <span> Medical - group</span>   
        </div>
    );
}

export default Logo