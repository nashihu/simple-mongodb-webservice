//package com.ahmadmongo.ahmadmongo.config;
//
//import com.ahmadmongo.ahmadmongo.importedClass.HeaderConstant;
//import iconpln.sinergi.successionplan.model.response.UserJwtDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.Nonnull;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Objects;
//import java.util.Optional;
//
//@Configuration
//@EnableJpaAuditing
//public class AuditConfig {
//
//    @Bean
//    public AuditorAware<Long> auditorProvider() {
//        return new SpringSecurityAuditAwareImpl();
//    }
//}
//
//@Slf4j
//class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {
//    @Override
//    @Nonnull
//    public Optional<Long> getCurrentAuditor() {
//        HttpServletRequest request = ((ServletRequestAttributes)
//                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        UserJwtDto userJwtDto = (UserJwtDto) request.getAttribute(HeaderConstant.CUSTOMER_OBJECT_SESSION);
//        log.info("curr auditor : {}", userJwtDto);
//        return Optional.of(userJwtDto.getId());
//    }
//}