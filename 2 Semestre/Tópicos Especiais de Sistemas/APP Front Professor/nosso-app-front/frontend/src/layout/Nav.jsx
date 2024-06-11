
import { NavLink } from "react-router-dom";

function Nav(){
    return (
        <nav>
            <ul>
                <li><NavLink to="/">Home</NavLink></li>
                <li><NavLink to="/cadastroAluno" >Area do Aluno</NavLink></li>
                <li><NavLink to="/cadastroTreino">Cadastros</NavLink></li>
            </ul>
        </nav>
    );
}

export default Nav;