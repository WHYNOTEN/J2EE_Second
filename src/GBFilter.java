import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "GBFilter")
public class GBFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding=req.getCharacterEncoding();//原来的编码
        encoding="utf-8";//新编码
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
