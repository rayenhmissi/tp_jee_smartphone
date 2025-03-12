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

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {

    ISmartphoneDao metier;

    @Override
    public void init() throws ServletException {
        metier = new SmartphoneDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

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
            request.getRequestDispatcher("saisiesmart.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String modele = request.getParameter("modele");
            String marque = request.getParameter("marque");
            int ram = Integer.parseInt(request.getParameter("ram"));
            int stockage = Integer.parseInt(request.getParameter("stockage"));
            double prix = Double.parseDouble(request.getParameter("prix"));

            // Create a new Smartphone object with null ID (will be set by DAO)
            Smartphone s = new Smartphone();
            s.setMarque(marque);
            s.setModele(modele);
            s.setRam(ram);
            s.setStockage(stockage);
            s.setPrix(prix);

            // Save and get the updated object with ID
            s = metier.save(s);

            request.setAttribute("smartphone", s);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteSmartphone(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Smartphone s = metier.getSmartphone(id);
            request.setAttribute("smartphone", s);
            request.getRequestDispatcher("editersmart.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String modele = request.getParameter("modele");
            String marque = request.getParameter("marque");
            int ram = Integer.parseInt(request.getParameter("ram"));
            int stockage = Integer.parseInt(request.getParameter("stockage"));
            double prix = Double.parseDouble(request.getParameter("prix"));

            // Create a new Smartphone object with the provided ID
            Smartphone s = new Smartphone();
            s.setId(id);
            s.setMarque(marque);
            s.setModele(modele);
            s.setRam(ram);
            s.setStockage(stockage);
            s.setPrix(prix);

            metier.updateSmartphone(s);
            request.setAttribute("smartphone", s);
            response.sendRedirect("chercher.do?motCle=");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}