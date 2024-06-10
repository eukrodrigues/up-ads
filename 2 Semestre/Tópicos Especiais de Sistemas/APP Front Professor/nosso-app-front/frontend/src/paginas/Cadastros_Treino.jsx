

import axios from "axios";
import { useState } from "react";

function Cadastro() {
    const [aluno, setAluno] = useState({ nome: "", datanascimento: "" });
    const [professor, setProfessor] = useState({ nome: "", especialidade: "" });
    const [treino, setTreino] = useState({ alunoId: "", dia: "", exercicio: "" });

    function handleChange(e, setState) {
        const { name, value } = e.target;
        setState(prevState => ({ ...prevState, [name]: value }));
    }

    function handleSalvarAluno(e) {
        e.preventDefault();
        axios.post("http://localhost:5193/aluno", aluno)
            .then(() => setAluno({ nome: "", datanascimento: "" }));
    }

    function handleSalvarProfessor(e) {
        e.preventDefault();
        axios.post("http://localhost:5193/professor", professor)
            .then(() => setProfessor({ nome: "", especialidade: "" }));
    }

    function handleSalvarTreino(e) {
        e.preventDefault();
        axios.post("http://localhost:5193/treino", treino)
            .then(() => setTreino({ alunoId: "", dia: "", exercicio: "" }));
    }

    return (
        <div>
            <h1>Cadastrar Aluno</h1>
            <form onSubmit={handleSalvarAluno}>
                <label htmlFor="nomeAluno">Nome</label>
                <input
                    type="text"
                    id="nomeAluno"
                    name="nome"
                    value={aluno.nome}
                    onChange={(e) => handleChange(e, setAluno)}
                />
                <label htmlFor="datanascimento">Data de Nascimento</label>
                <input
                    type="text"
                    id="datanascimento"
                    name="datanascimento"
                    value={aluno.datanascimento}
                    onChange={(e) => handleChange(e, setAluno)}
                />
                <button type="submit">Salvar</button>
            </form>

            <h1>Cadastrar Professor</h1>
            <form onSubmit={handleSalvarProfessor}>
                <label htmlFor="nomeProfessor">Nome</label>
                <input
                    type="text"
                    id="nomeProfessor"
                    name="nome"
                    value={professor.nome}
                    onChange={(e) => handleChange(e, setProfessor)}
                />
                <label htmlFor="especialidade">Especialidade</label>
                <input
                    type="text"
                    id="especialidade"
                    name="especialidade"
                    value={professor.especialidade}
                    onChange={(e) => handleChange(e, setProfessor)}
                />
                <button type="submit">Salvar</button>
            </form>

            <h1>Cadastrar Treino</h1>
            <form onSubmit={handleSalvarTreino}>
                <label htmlFor="alunoId">Aluno ID</label>
                <input
                    type="text"
                    id="alunoId"
                    name="alunoId"
                    value={treino.alunoId}
                    onChange={(e) => handleChange(e, setTreino)}
                />
                <label htmlFor="dia">Dia</label>
                <input
                    type="text"
                    id="dia"
                    name="dia"
                    value={treino.dia}
                    onChange={(e) => handleChange(e, setTreino)}
                />
                <label htmlFor="exercicio">Exercício</label>
                <input
                    type="text"
                    id="exercicio"
                    name="exercicio"
                    value={treino.exercicio}
                    onChange={(e) => handleChange(e, setTreino)}
                />
                <button type="submit">Salvar</button>
            </form>
        </div>
    );
}

export default Cadastro;