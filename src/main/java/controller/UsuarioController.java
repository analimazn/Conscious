/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuario_controller")
public class UsuarioController extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res) throws IOException{
        
        Usuario u = new Usuario();
        u.setNomeUsuario("fabricio");
        u.setSenha(Double.toString((int) (Math.random()*1000)));
        res.setContentType("application/json");
        PrintWriter escritorResposta = res.getWriter();
        escritorResposta.write(u.paraJSONString());
        escritorResposta.close();       
    }
}
