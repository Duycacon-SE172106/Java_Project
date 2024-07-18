package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Entities.EntitiesDTO;

public final class shopping_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vi\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Shopping Page</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("                background-color: #f0f2f5;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form {\n");
      out.write("                background: #ffffff;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                align-items: center;\n");
      out.write("                width: 400px; /* Đặt chiều rộng của form */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            select, input[type=\"number\"] {\n");
      out.write("                margin-bottom: 16px;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px solid #ccd0d5;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                max-width: 400px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .button-container {\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                max-width: 400px;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center;\n");
      out.write("                margin-top: 10px; /* Đặt margin phía trên */\n");
      out.write("                margin: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                padding: 10px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 6px;\n");
      out.write("                background-color: #1877f2;\n");
      out.write("                color: white;\n");
      out.write("                font-size: 16px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 48%; \n");
      out.write("                margin-right:  10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #165eab;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("   <body>\n");
      out.write("    <form action=\"MainController\" method=\"POST\">\n");
      out.write("        ");

            List<EntitiesDTO> productList = (List<EntitiesDTO>) session.getAttribute("LIST_PRODUCTS");
            if (productList != null) {
        
      out.write("\n");
      out.write("        <label for=\"product\">Type:</label>\n");
      out.write("        <select id=\"product\" name=\"product\">\n");
      out.write("            ");

                for (EntitiesDTO product : productList) {
                    if (!product.isNotSale()) {
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print( product.getMobileId() );
      out.write('-');
      out.print( product.getMobileName() );
      out.write('-');
      out.print( product.getPrice() );
      out.write('-');
      out.print( product.getYearOfProduct() );
      out.write("\">\n");
      out.write("                ");
      out.print( product.getMobileName() );
      out.write('-');
      out.print( product.getPrice() );
      out.write("$\n");
      out.write("            </option>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("        </select>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <label for=\"quantity\">Quantity:</label>\n");
      out.write("        <input type=\"number\" id=\"quantity\" name=\"quantity\" min=\"1\">\n");
      out.write("        <div class=\"button-container\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Add\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"View\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Home\"/>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
