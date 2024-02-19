package controller;

import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.vo.ReceitaVO;
import model.bo.ReceitaBO;

@Path("/receita") // Mudei o caminho para ser "/receita" para evitar ambiguidade
public class ReceitaRest {

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReceitaVO cadastrarReceitaController(ReceitaVO receitaVO) {
        ReceitaBO receita = new ReceitaBO();
        return receita.cadastrarReceitaBo(receitaVO);
    }

    @GET
    @Path("/listar/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReceitaVO> consultarReceitasController(@PathParam("idUsuario") int idUsuario) {
        ReceitaBO recetaBO = new ReceitaBO();
        return recetaBO.consultarTodasReceitasBO(idUsuario);
    }

    @GET
    @Path("/pesquisar/{idReceita}") // Mudei para "idReceita" para evitar ambiguidade
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReceitaVO consultarReceitaController(@PathParam("idReceita") int idReceita) {
        ReceitaBO receitaBO = new ReceitaBO();
        return receitaBO.consultarReceitaBO(idReceita);
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean atualizarReceitaController(ReceitaVO receitaVO) {
        ReceitaBO receitaBO = new ReceitaBO();
        return receitaBO.atualizarReceitaBO(receitaVO);
    }

    @DELETE
    @Path("/excluir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean excluirReceitaController(ReceitaVO receitaVO) {
        ReceitaBO receitaBO = new ReceitaBO();
        return rec  eitaBO.excluirReceitaBO(receitaVO);
    }
}
