package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver vr(){
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setViewClass(JstlView.class);
        irvr.setPrefix("/web/");
        irvr.setSuffix(".jsp");
        return irvr;
    }
    public void addFormatters(FormatterRegistry formatterRegistry) { }

    public void configureMessageConverters(List<HttpMessageConverter<?>> list) { }

    public void extendMessageConverters(List<HttpMessageConverter<?>> list) { }

    public Validator getValidator() { return null; }

    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) { }

    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) { }

    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) { }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) { }

    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) { }

    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) { }

    public void addInterceptors(InterceptorRegistry interceptorRegistry) { }

    public MessageCodesResolver getMessageCodesResolver() { return null; }

    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/signin").setViewName("signin");
        viewControllerRegistry.addViewController("/").setViewName("/index");
        viewControllerRegistry.addViewController("/admin/home").setViewName("/admin");
    }

    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) { }

    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) { }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) { }

}
