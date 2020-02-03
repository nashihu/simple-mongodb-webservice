//package com.ahmadmongo.ahmadmongo.config;
//
//import com.ahmadmongo.ahmadmongo.importedClass.HeaderConstant;
//import com.ahmadmongo.ahmadmongo.repo.SysUserRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import iconpln.common.util.Check;
//import iconpln.sinergi.successionplan.model.response.UserJwtDto;
//import iconpln.sinergi.successionplan.service.constant.Constant;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class JwtFilter extends OncePerRequestFilter {
//    @Autowired
//    private SysUserRepository sysUserRepository;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//            chain.doFilter(request, response);
//            return;
//        }
//        final String authHeader = request.getHeader(HeaderConstant.AUTHORIZATION);
//        if (!StringUtils.isBlank(authHeader)) {
//            final String token = authHeader.substring(7);
//            try {
//                final Claims claims = Jwts.parser().setSigningKey(Constant.JWT_SECRET_KEY).parseClaimsJws(token)
//                        .getBody();
//                String subject = claims.getSubject();
//                Check.isTrue(!StringUtils.isBlank(subject), "Token Invalid");
//                UserJwtDto dto = objectMapper.readValue(subject, UserJwtDto.class);
//
//                request.setAttribute("claims", claims);
//                log.info("User Auth {}", dto);
//
//                request.setAttribute(HeaderConstant.USER_SESSION, dto.getUsername());
//                request.setAttribute(HeaderConstant.CUSTOMER_OBJECT_SESSION, dto);
//            } catch (Exception e) {
//                log.error("failed to extract claim {}", e.getMessage());
//                response.setStatus(401);
//                response.getWriter().print("Invalid token");
//                response.getWriter().flush();
//                return;
//            }
//            chain.doFilter(request, response);
//        } else {
//            response.setStatus(401);
//            response.getWriter().print("Invalid token");
//            response.getWriter().flush();
//            return;
//        }
//    }
//}