package tobyspring.helloboot.v15.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

/**
 * @Condtitional() 조건 : 외부라이브러리에 해당하는 이름이 있으면 true
 * - ex. `Tomcat`이 외부라이브러리에 포함되어 있을 때 @Conditional() 조건 true
 */
public class MyOnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String value = (String) attrs.get("value");
        return ClassUtils.isPresent(value, context.getClassLoader()); //여기에 해당하는 클래스 이름이 존재하면 true
    }
}
