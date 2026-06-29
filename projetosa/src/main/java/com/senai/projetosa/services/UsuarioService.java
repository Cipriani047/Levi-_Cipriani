package com.senai.projetosa.services;

import com.senai.projetosa.dtos.*;
import com.senai.projetosa.models.UsuarioModel;
import com.senai.projetosa.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public RespostaDTO cadastrar(RequisicaoDTO usuarioDto){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setEmail(usuarioDto.getEmail());
        usuarioModel.setSenha(usuarioDto.getSenha());
        usuarioModel.setMatricula(usuarioDto.getMatricula());
        usuarioModel.setDataNascimento(usuarioDto.getDataNascimento());
        repository.save(usuarioModel);

        RespostaDTO resposta = new RespostaDTO();
        resposta.setMensagem("sucesso");
        return resposta ;
    }

    public RespostaDTO atualizar(Long id, UsuarioDTO usuarioDto){
        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){
            UsuarioModel usuario = usuarioOP.get();
            usuario.setNome(usuarioDto.getNome());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setSenha(usuarioDto.getSenha());
            usuario.setDataNascimento(usuarioDto.getDataNascimento());
            usuario.setMatricula(usuarioDto.getMatricula());
            repository.save(usuario);
            RespostaDTO resposta = new RespostaDTO();
            resposta.setMensagem("sucesso");
            return resposta ;
        }
        RespostaDTO resposta = new RespostaDTO();
        resposta.setMensagem("NÃO FOI POSSÍVEL ATUALIZAR O USUÁRIO! ID = " + id);
        return resposta ;
    }

    public RespostaDTO excluir(Long id){
        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){
            repository.delete(usuarioOP.get());
            RespostaDTO resposta = new RespostaDTO();
            resposta.setMensagem("sucesso");
            return resposta;
        }
        RespostaDTO resposta = new RespostaDTO();
        resposta.setMensagem("NÃO FOI POSSÍVEL REMOVER O USUÁRIO! ID = " + id);
        return resposta ;
    }

    public UsuarioDTO obterUsuario(Long id){
        UsuarioDTO usuarioDto = new UsuarioDTO();
        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()){
            UsuarioModel usuario = usuarioOP.get();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setSenha(usuario.getSenha());
            usuarioDto.setMatricula(usuario.getMatricula());
            usuarioDto.setDataNascimento(usuario.getDataNascimento());
            return usuarioDto;
        }
        return usuarioDto;
    }

    public List<UsuarioDTO> obterUsuarios(){
        List<UsuarioDTO> listaUsuarioDto = new ArrayList<>();
        List<UsuarioModel> listaUsuarioModel = repository.findAll();

        for (UsuarioModel usuario : listaUsuarioModel){
            UsuarioDTO usuarioDto = new UsuarioDTO();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNome(usuario.getNome());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setSenha(usuario.getSenha());
            usuarioDto.setMatricula(usuario.getMatricula());
            usuarioDto.setDataNascimento(usuario.getDataNascimento());
            listaUsuarioDto.add(usuarioDto);
        }
        return listaUsuarioDto;
    }

    public UsuarioSessaoDTO validarEmail(LoginDTO emailDTO){
        UsuarioSessaoDTO usuarioSessao = new UsuarioSessaoDTO();
        Optional<UsuarioModel> usuarioOP = repository.findByEmailAndSenha(emailDTO.getEmail(),emailDTO.getSenha());

        if (usuarioOP.isPresent() ){
            usuarioSessao.setId(usuarioOP.get().getId());
            usuarioSessao.setNome(usuarioOP.get().getNome());
        }
        return usuarioSessao;
    }
}