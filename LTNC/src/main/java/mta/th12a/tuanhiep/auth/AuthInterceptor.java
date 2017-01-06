package mta.th12a.tuanhiep.auth;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Auth roleAnnotation = AnnotationUtils
                .findAnnotation(method, Auth.class);
        Integer role = roleAnnotation != null ? roleAnnotation.role() : null;
        HttpSession session = request.getSession();
        boolean isLogined = session.getAttribute("isLogin") != null ? (Boolean) session
                .getAttribute("isLogin") : false;
                Integer loginRole = session.getAttribute("role") != null ? (Integer) session
                .getAttribute("role") : null;
        if (role != null) {
            if (!isLogined) {
                response.sendRedirect("/LTNC/admin/authen/login");
                return false;
            } else {
            	if(!role.equals(loginRole))
            	{
            		response.sendRedirect("/LTNC/admin/authen/login");
                    return false;
            	}
            }
        }
 
        return true;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}

