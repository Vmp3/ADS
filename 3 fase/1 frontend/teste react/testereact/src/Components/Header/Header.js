import Logo from '../Logo/Logo';
import HeaderIcone from '../HeaderIcone/HeaderIcone';
import './Header.css';
import { useState, useEffect } from 'react';

/**
 * 
 * @returns {Comment} dwqdqqqdqwdqwddqdqdwq
 */


const Header = () => {
    /**
 * 
 * @param {Date} data pega data atual
 * @returns (string) a data formatada erm dd/mm/yyyy hh:mm
 */

    const [dataAtual, setDataAtual] = useState(new Date())

    useEffect(() => {
        document.getElementById = `Header: ${dataAtual.toString()}`});

    function formataData(data){
        const dia = data.getDate().toString().padStart(2,'0');
        const mes = (data.getMonth()+ 1).toString().padStart(2,'0');
        const ano = (data.getFullYear()).toString();
        const hora = data.getHours().toString().padStart(2,'0');
        const minuto = data.getMinutes().toString().padStart(2,'0');
        const segundo = data.getSeconds().toString().padStart(2,'0');
        return `${dia}/${mes}/${ano} ${hora}:${minuto}:${segundo}`;
    }


    const atualizarHora = () => {
        setDataAtual(new Date())
    }

    return(
        <div className='head-container'> 
            <Logo />
            <div>{formataData(new Date)} </div>
            <HeaderIcone/> 
            <button onClick={() => setDataAtual(atualizarHora)}> atualizar</button>
        </div>
    );
}

export default Header;