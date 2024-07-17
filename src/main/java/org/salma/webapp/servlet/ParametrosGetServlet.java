package org.salma.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String saudacao = req.getParameter("saudacao");
        String nome = req.getParameter("nome");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <title>Parametros Get da url</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Parametros Get da url!</h1>");
        if (saudacao != null && nome != null) {
            out.println("        <h2>A saudação enviada é: " + saudacao + " " + nome + "</h2>");
        } else if (saudacao != null) {
            out.println("        <h2>A saudação enviada é: " + saudacao + "</h2>");
        } else if (nome != null) {
            out.println("        <h2>Ola meu nome é " + nome + "</h2>");
        } else {
            out.println("<h2>Não foram passados os parâmetros cumprimentos nem nome</h2>");
        }

        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h3>O código enviado é : " + codigo + "</h3>");
        } catch (NumberFormatException e){
            out.println("<h3>O código não foi  enviado, é null</h3>");
        }
        out.println("    </body>");
        out.println("</html>");
        out.close();
    }
}
