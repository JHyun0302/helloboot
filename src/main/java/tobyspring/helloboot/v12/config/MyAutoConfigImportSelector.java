package tobyspring.helloboot.v12.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동 구성 대상 후보를 지정
 * resources.META-INF.spring.tobyspring.helloboot.v12.config.MyAutoConfiguration.imports
 */
public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();

//        for (String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(candidate ->
                autoConfigs.add(candidate));


        return autoConfigs.toArray(new String[0]); //List<String> -> String Array 변환
//        return autoConfigs.stream().toArray(String[]::new); //List<String> -> String Array 변환
//        return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);


        //같은 문장
//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
    }
}
