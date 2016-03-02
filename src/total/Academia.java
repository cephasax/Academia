package total;

import java.util.ArrayList;

public class Academia {

    private String nome;

    private ArrayList<Usuario> usuarios;

    public Academia(String nome) {
        this.nome = new String(nome);
        this.usuarios = new ArrayList<Usuario>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Aluno buscarAlunoCPF(String CPF) {
        for (Usuario a : usuarios) {
            if (a instanceof Aluno) {
                if (((Aluno) a).getCPF().equals(CPF)) {
                    return (Aluno) a;
                }
            }
        }
        return null;
    }

    public Professor buscarProfessorCREF(String cref) {
        for (Usuario p : usuarios) {
            if (p instanceof Professor) {
                if (((Professor) p).getCREF().equals(cref)) {
                    return (Professor) p;
                }
            }
        }
        return null;

    }
}
