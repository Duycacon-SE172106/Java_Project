/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.EntitiesDAO;
import Entities.EntitiesDTO;
import Users.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chinl
 */
public class SearchController extends HttpServlet {

    private static final String SUCCESS01 = "staff.jsp";
    private static final String ERROR01 = "staff.jsp";
    private static final String SUCCESS02 = "user.jsp";
    private static final String ERROR02 = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        if (loginUser.getRole() == 1) {
            String url = ERROR01;
            try {
                String search = request.getParameter("search");
                EntitiesDAO dao = new EntitiesDAO();
                List<EntitiesDTO> listProducts = dao.getListProducts(search);
                if (!listProducts.isEmpty()) {
                    request.setAttribute("LIST_PRODUCTS", listProducts);
                    url = SUCCESS01;
                }
            } catch (Exception e) {
                log("Error at SearchController: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }
        } else if(loginUser.getRole()==0){
            String url=ERROR02;
        try {
            String searchMin= request.getParameter("searchMin");
            String searchMax= request.getParameter("searchMax");
            int value01=Integer.parseInt(searchMin);
            int value02=Integer.parseInt(searchMax);
            EntitiesDAO dao= new EntitiesDAO();
            List<EntitiesDTO> listProducts = dao.getListProducts02(value01,value02);
            if(!listProducts.isEmpty()){
                request.setAttribute("LIST_PRODUCTS", listProducts);
                url=SUCCESS02;
            }
        }catch(Exception e){
            log("Error at SearchController: "+e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
