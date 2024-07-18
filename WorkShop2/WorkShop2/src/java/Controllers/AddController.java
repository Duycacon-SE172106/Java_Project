/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Cart;
import Entities.EntitiesDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chinl
 */
public class AddController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS = "shopping.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String strProduct =request.getParameter("product");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String str[] = strProduct.split("-");
            String mobileId = str[0];
            String mobileName = str[1];
            float price = Float.parseFloat(str[2]);
            int year = Integer.parseInt(str[3]);
            HttpSession session = request.getSession();
            if(session!=null){
                Cart cart=(Cart)session.getAttribute("CART");
                if(cart==null){
                    cart = new Cart();
                }
                EntitiesDTO product= new EntitiesDTO(mobileId, "", price, mobileName, year, quantity, false);
                // tới đây
                boolean check = cart.add(product);
                if(check){
                    session.setAttribute("CART", cart);
                    url= SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at Add Controller: " + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
