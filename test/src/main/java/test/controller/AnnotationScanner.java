package test.controller;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AnnotationScanner {

    private Map<String, Object> container = new HashMap<>();

    public void scan(String basePackage) {
        String basePath = basePackage.replace(".", "/");
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL resource = cl.getResource(basePath);

        if (resource == null) {
            throw new RuntimeException("경로를 찾을 수 없습니다: " + basePath);
        }

        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith(".class")) {
                try {
                    String className = basePackage + "." + file.getName().replace(".class", "");
                    Class<?> cls = Class.forName(className);

                    if (cls.isAnnotationPresent(Controller.class)) {
                        Object instance = cls.newInstance(); // or cls.getDeclaredConstructor().newInstance()
                        container.put(cls.getName(), instance);
                        System.out.println("등록됨: " + cls.getName());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String className) {
        return container.get(className);
    }

    public Collection<Object> getAllBeans() {
        return container.values();
    }
}
