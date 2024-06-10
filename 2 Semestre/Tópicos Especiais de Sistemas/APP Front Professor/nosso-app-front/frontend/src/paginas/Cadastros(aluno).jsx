import axios from "axios";
import { useState, useEffect } from "react";

function VisualizarAlunosETreinos() {
    const [alunos, setAlunos] = useState([]);
    const [treinos, setTreinos] = useState([]);
    const [selectedAlunoId, setSelectedAlunoId] = useState(null);

    useEffect(() => {
        getAlunos();
    }, []);

    function getAlunos() {
        axios.get("http://localhost:5193/aluno")
            .then((resposta) => {
                setAlunos(resposta.data);
            });
    }

    function getTreinos(alunoId) {
        axios.get(`http://localhost:5193/treino/aluno/${alunoId}`)
            .then((resposta) => {
                setTreinos(resposta.data);
            });
    }

    function handleVerTreinos(alunoId) {
        setSelectedAlunoId(alunoId);
        getTreinos(alunoId);
    }

    function getLinhasDaTabelaAlunos() {
        return alunos.map(aluno => (
            <tr key={aluno._id}>
                <td>{aluno.id}</td>
                <td>{aluno.nome}</td>
                <td>{aluno.dataNascimento}</td>
                <td>
                    <button onClick={() => handleVerTreinos(aluno._id)}>Ver Treinos</button>
                </td>
            </tr>
        ));
    }

    function getLinhasDaTabelaTreinos() {
        return treinos.map(treino => (
            <tr key={treino._id}>
                <td>{treino.dia}</td>
                <td>{treino.exercicio}</td>
            </tr>
        ));
    }

    return (
        <div>
            <h1>Alunos</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {getLinhasDaTabelaAlunos()}
                </tbody>
            </table>
            
            {selectedAlunoId && (
                <>
                    <h2>Treinos</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Dia</th>
                                <th>Exercício</th>
                            </tr>
                        </thead>
                        <tbody>
                            {getLinhasDaTabelaTreinos()}
                        </tbody>
                    </table>
                </>
            )}
        </div>
    );
}

export default VisualizarAlunosETreinos;
