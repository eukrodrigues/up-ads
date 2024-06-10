import React from "react";
import { Routes, Route } from "react-router-dom";
import Layout from "./layout/Layout";
import Home from "./paginas/Home";
import CadastroAluno from "./paginas/Cadastros(aluno)";
import CadastroTreino from "./paginas/Cadastros_Treino";

function App(){
    return (
        <> 
            <Routes>
                <Route path="/" element={<Layout><Home /></Layout>}/>
                <Route path="/cadastroAluno" element={<Layout><CadastroAluno/></Layout>}/>
                <Route path="/cadastroTreino" element={<Layout><CadastroTreino /></Layout>}/>
            </Routes>
        </>
    );
}

export default App;