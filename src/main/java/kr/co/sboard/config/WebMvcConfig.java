package kr.co.sboard.config;

import kr.co.sboard.interceptor.AppinfoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AppInfo appInfo;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppinfoInterceptor(appInfo));
    }
}
