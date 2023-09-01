package tobyspring.helloboot.v11.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * DeferredImportSelector : 동적으로 원하는 라이브러리 선택 가능
 */
public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "tobyspring.helloboot.v11.config.autoconfig.DispatcherServletConfig",
                "tobyspring.helloboot.v11.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
