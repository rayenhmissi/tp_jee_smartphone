package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ISmartphoneDao;
import dao.SmartphoneDaoImpl;
import metier.entities.Smartphone;
import metier.entities.SmartphoneModele;

@WebServlet(name = "cs", urlPatterns = {"/controleur", "*.go"})
public class ControleurServlet extends HttpServlet {
    private ISmartphoneDao metier;

    @Override
    public void init() throws ServletException {
        metier = new SmartphoneDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        try {
            if (path.equals("/index.do")) {
                request.getRequestDispatcher("smarts.jsp").forward(request, response);
            } else if (path.equals("/chercher.do")) {
                String motCle = request.getParameter("motCle");
                SmartphoneModele model = new SmartphoneModele();
                model.setMotCle(motCle);
                List<Smartphone> smarts = metier.smartsParMC(motCle);
                model.setSmarts(smarts);
                request.setAttribute("model", model);
                request.getRequestDispatcher("smarts.jsp").forward(request, response);
            } else if (path.equals("/saisie.do")) {
                String marque = request.getParameter("marque");
                String modele = request.getParameter("modele");
                String ram = request.getParameter("ram");
                String stockage = request.getParameter("stockage");
                double prix = Double.parseDouble(request.getParameter("prix"));
                
                Smartphone s = new Smartphone(marque, modele, ram, stockage, prix);
                Smartphone savedSmartphone = metier.save(s);
                request.setAttribute("smartphone", savedSmartphone);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            } else if (path.equals("/update.do")) {
                Long id = Long.parseLong(request.getParameter("id"));
                String marque = request.getParameter("marque");
                String modele = request.getParameter("modele");
                String ram = request.getParameter("ram");
                String stockage = request.getParameter("stockage");
                double prix = Double.parseDouble(request.getParameter("prix"));
                
                Smartphone s = new Smartphone(id, marque, modele, ram, stockage, prix);
                metier.updateSmartphone(s);
                response.sendRedirect("chercher.do?motCle=");
            } else if (path.equals("/supprimer.do")) {
                Long id = Long.parseLong(request.getParameter("id"));
                metier.deleteSmartphone(id);
                response.sendRedirect("chercher.do?motCle=");
            } else if (path.equals("/editer.do")) {
                Long id = Long.parseLong(request.getParameter("id"));
                Smartphone s = metier.getSmartphone(id);
                request.setAttribute("smartphone", s);
                request.getRequestDispatcher("editer.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            // Gestion des erreurs
            request.setAttribute("erreur", e.getMessage());
            request.getRequestDispatcher("erreur.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}